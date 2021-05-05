import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.*;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private HashMap<String, Object> mapWithAnswer = new AskAndAnswer().AskAndAnswer;
    static Register register = new Register();
    static TeacherRegister teacherRegister = new TeacherRegister();
    private static BufferedAskAndAnswer bufferedAskAndAnswer;
    AdaptationNameGroup adaptationNameGroup = new AdaptationNameGroup();
    AdaptationNameGroupTeacher adaptationNameGroupTeacher = new AdaptationNameGroupTeacher();
    static RegularSenderSchedule regularSenderSchedule = new RegularSenderSchedule();
    Date date = new Date();
    String groups;
    boolean b = false;
    long time;

    public static void main(String[] args) throws Exception {

        try {
//----------------------------------------------------------------------------------------------------------------------
            //Востановливаем данные о пользователях


            FileInputStream FIS = new FileInputStream("C:/Bot/Text/Users.txt");
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            register = (Register) OIS.readObject();
            FIS.close();
            OIS.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        FileInputStream teacherFIS = new FileInputStream("C:/Bot/Text/UsersTeach.txt");
        ObjectInputStream teacherOIS = new ObjectInputStream(teacherFIS);
        teacherRegister = (TeacherRegister) teacherOIS.readObject();
        teacherFIS.close();
        teacherOIS.close();

        System.out.println(teacherRegister.longBooleanHashMap);
        System.out.println(register.longBooleanHashMap);
//----------------------------------------------------------------------------------------------------------------------
        //Создаем и инициализируем список вопросов - ответов
        bufferedAskAndAnswer = new BufferedAskAndAnswer();
//----------------------------------------------------------------------------------------------------------------------
        ApiContextInitializer.init();
        try {
            new TelegramBotsApi().registerBot(new Bot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //regularSenderSchedule.SendToTeacher(teacherRegister);
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        time = date.getTime();
        if (!message.hasText())
            b = true;

        if(!b) {
            if (register.CheckInitialization(message.getChatId())) {
                if (message.getText().toUpperCase().equals("RESTART") || message.getText().toUpperCase().equals("/RESTART")) {
                    register.RemoveUser(message.getChatId());
                    teacherRegister.RemoveUser(message.getChatId());
                    try {
                        register.SerializeRegister(register);
                        teacherRegister.SerializeRegister(teacherRegister);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sendMsg(message, "Введите вашу группу");
                } else {
                    // полный функционал
//----------------------------------------------------------------------------------------------------------------------

                    if (register.longBooleanHashMap.get(message.getChatId()).getTime() < message.getDate()) {

                        switch (register.longBooleanHashMap.get(message.getChatId()).getFaculty()) {
                            case "ЭКФ" -> mapWithAnswer = BufferedAskAndAnswer.EKF;
                            case "ФЭиУ" -> mapWithAnswer = BufferedAskAndAnswer.FEandU;
                            case "ФТРиР" -> mapWithAnswer = BufferedAskAndAnswer.FTRandR;
                            case "ФГиГФ" -> mapWithAnswer = BufferedAskAndAnswer.FGandGF;
                            case "ГРФ" -> mapWithAnswer = BufferedAskAndAnswer.GRF;
                            case "ГГФ" -> mapWithAnswer = BufferedAskAndAnswer.GGF;
                        }
                        try {
                            try {
                                if (!teacherRegister.longBooleanHashMap.get(message.getChatId()).getChair().isEmpty()) {
                                    if (message.getText().equals("Расписание")) {
                                        ExelParsTeacher exelParsTeacher = new ExelParsTeacher();
                                        try {
                                            sendMsg(message, teacherRegister.longBooleanHashMap.get(message.getChatId()).getName() + "\n" + "\n" + exelParsTeacher.readWorkbook(teacherRegister.longBooleanHashMap.get(message.getChatId()).getName()));
                                        } catch (IOException ioException) {
                                            ioException.printStackTrace();
                                        }
                                    } else if (message.getText().equals("Отправить сообщение группе")) {
                                        sendMsg(message, "введите название группы или групп(через запятую), которой(ым) вы бы хотели отправить сообщение");
                                    } else if (teacherRegister.CheckGroup(message.getText())) {
                                        sendMsg(message, "введите сообщение для его отправки");
                                        groups = adaptationNameGroup.Adapter(message.getText());
                                    } else {
                                        for (User user : register.longBooleanHashMap.values()) {
                                            if (user.getGroup().equals(groups)) {

                                                SendMessage sendMessage = new SendMessage();
                                                sendMessage.setChatId(user.getUserID());
                                                sendMessage.setText("Вам пришло сообщение от "+teacherRegister.longBooleanHashMap.get(message.getChatId()).getName()+": "+message.getText());

                                                try {
                                                    sendMessage(sendMessage);
                                                } catch (Exception e) {

                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                try {

                                    SendPhoto sendPhoto = new SendPhoto();
                                    sendPhoto.setChatId(message.getChatId());
                                    sendPhoto.setNewPhoto(new File(String.valueOf(mapWithAnswer.get(message.getText()))));
                                    sendPhoto(sendPhoto);


                                } catch (Exception ee) {
                                    sendMsg(message, String.valueOf(mapWithAnswer.get(message.getText())));

                                }
                                register.longBooleanHashMap.get(message.getChatId()).setTime(message.getDate() + 1);

                            }
                        } catch (Exception e) {

                        }
                    }
                }

//----------------------------------------------------------------------------------------------------------------------
            } else if (!(message.getText().equals("/start"))) {
                try {
                    if (register.Registration(message.getChatId(), adaptationNameGroup.Adapter(message.getText()))) {
                        register.Registration(message.getChatId(), adaptationNameGroup.Adapter(message.getText()));
                        sendMsg(message, register.AnserInformation(message.getChatId()));
                        sendMsg(message, "Регистрация пройдена успешно!");
                        register.SerializeRegister(register);
                    } else if (teacherRegister.Registration(message.getChatId(), message.getText())) {
                        teacherRegister.Registration(message.getChatId(), message.getText());
                        sendMsg(message, teacherRegister.AnswerInformation(message.getChatId()));
                        sendMsg(message, "Регистрация пройдена успешно");
                        teacherRegister.SerializeRegister(teacherRegister);
                        System.out.println("tututut");
                    } else {
                        try {
                            System.out.println("chto ne tack?");
                            teacherRegister.Registration(message.getChatId(),teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                            sendMsg(message,"Ошибка! Возможно вы неправильно ввели группу, попробуйте еще раз. Пример: ПИ-20");
                            register.RemoveUser(message.getChatId());

                        } catch (Exception e) {
                            System.out.println("фото АТСУТВУЕТ");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if(message.getText().equals("/start")){
                try{
                if( register.longBooleanHashMap.get(message.getChatId()).getUserID() == message.getChatId() ){
                    sendMsg(message,"В системе уже сть ваша учетная запись, если вы хотите начать работу с ботом сначала введите команде /restart");
                    }
                }catch (Exception e) {
                    sendMsg(message, "Здравствуйте, вас приветствует чат-бот МГРИ, который содержит информацию о часто задаваемых вопросах. Введите вашу группу с клавиатуры, например: (ПИ20)");
                }
            }
            else {
                System.out.println("start");

                sendMsg(message, String.valueOf(mapWithAnswer.get(message.getText())));

                try {
                    if (teacherRegister.Registration(message.getChatId(), message.getText())) {
                        teacherRegister.Registration(message.getChatId(), message.getText());
                        sendMsg(message, teacherRegister.AnswerInformation(message.getChatId()));
                        sendMsg(message, "Регистрация пройдена успешно");
                        teacherRegister.SerializeRegister(teacherRegister);
                    } else {
                        try {
                            sendMsg(message, "Что то пошло не так");
                            SendPhoto sendPhoto = new SendPhoto();
                            sendPhoto.setChatId(message.getChatId());
                            sendPhoto.setNewPhoto(new File("C:/Bot/photo/Что то пошло не так.jpg"));
                            sendPhoto(sendPhoto);
                            register.RemoveUser(message.getChatId());

                        } catch (Exception e) {
                            System.out.println("фото АТСУТВУЕТ");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            if (message.hasPhoto()) {
                for (User user : register.longBooleanHashMap.values()) {
                    if (user.getGroup().equals(groups)) {
                        int i = 0;
                        for (PhotoSize photo : message.getPhoto()) {
                            if(message.hasPhoto()) {
                                System.out.println("photo");
                                SendPhoto sendPhoto = new SendPhoto();
                                sendPhoto.setChatId(user.getUserID());
                                i++;
                                if(i == 2 || (i - 2) % 3 == 0) {
                                    SendMessage message1 = new SendMessage();
                                    message1.setText("Вам пришло изображение от: " + teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                                    message1.setChatId(user.getUserID());
                                    try {
                                        sendMessage(message1);
                                    } catch (TelegramApiException e) {
                                        e.printStackTrace();
                                    }


                                    sendPhoto.setPhoto(photo.getFileId());



                                }
                                try {
                                    sendPhoto(sendPhoto);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            else if(message.hasDocument()) {
                for (User user : register.longBooleanHashMap.values()) {
                    if (user.getGroup().equals(groups)) {
                        if(message.hasDocument()) {
                            SendMessage message1 = new SendMessage();
                            message1.setText("Вам пришел документ от: " + teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                            message1.setChatId(user.getUserID());
                            try {
                                sendMessage(message1);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }


                            SendDocument sendDocument = new SendDocument();
                            sendDocument.setChatId(user.getUserID());
                            sendDocument.setDocument(message.getDocument().getFileId());

                            try {
                                sendDocument(sendDocument);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            try {
                for (User user : register.longBooleanHashMap.values()) {
                    if (user.getGroup().equals(groups)) {
                        try {




                            SendVideo sendVideo = new SendVideo();
                            sendVideo.setChatId(user.getUserID());
                            sendVideo.setVideo(message.getVideo().getFileId());

                            try {
                                sendVideo(sendVideo);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            SendMessage message1 = new SendMessage();
                            message1.setText("Вам пришло видео от: " + teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                            message1.setChatId(user.getUserID());
                            try {
                                sendMessage(message1);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }catch (Exception e){

                        }
                    }
                }
            } catch (Exception e) {

            }
            try {
                for (User user : register.longBooleanHashMap.values()) {
                    if (user.getGroup().equals(groups)) {
                        try {

                            SendAudio sendAudio = new SendAudio();
                            sendAudio.setChatId(user.getUserID());
                            sendAudio.setAudio(message.getAudio().getFileId());

                            try {
                                sendAudio(sendAudio);
                            } catch (Exception e) {

                            }

                            SendMessage message1 = new SendMessage();
                            message1.setText("Вам пришло аудио от: " + teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                            message1.setChatId(user.getUserID());
                            try {
                                sendMessage(message1);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                for (User user : register.longBooleanHashMap.values()) {
                    if (user.getGroup().equals(groups)) {
                        try {

                            SendVoice sendVoice = new SendVoice();
                            sendVoice.setChatId(user.getUserID());
                            sendVoice.setVoice(message.getVoice().getFileId());

                            try {
                                sendVoice(sendVoice);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                            SendMessage message1 = new SendMessage();
                            message1.setText("Вам пришло голосовое сообщение от: " + teacherRegister.longBooleanHashMap.get(message.getChatId()).getName());
                            message1.setChatId(user.getUserID());
                            try {
                                sendMessage(message1);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }catch (Exception e) {

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            b = false;

        }
    }


    //Блок отправки сообщений
    public void sendMsg(Message message, String text) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try {
            //Отправка кнопки на панель
            setButton(sendMessage);
            //Отправка сообщения
            sendMessage(sendMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //создане кнопок
    public void setButton(SendMessage sendMessage) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRowBack = new KeyboardRow();
        KeyboardRow keyboardRowBack1 = new KeyboardRow();
        KeyboardRow keyboardRowSprav = new KeyboardRow();

        switch (sendMessage.getText()) {
            case ("Регистрация пройдена успешно!"):

                keyboardRow.add(new KeyboardButton("деканат"));
                keyboardRow.add(new KeyboardButton("расписание"));
                keyboardRow.add(new KeyboardButton("столовая"));
                keyboardRow1.add(new KeyboardButton("обратная связь"));
                keyboardRow1.add(new KeyboardButton("общая информция"));
                keyboardRow1.add(new KeyboardButton("справки"));

                keyboardRowList.add(keyboardRow);
                keyboardRowList.add(keyboardRow1);
                break;
            case ("назад"):

                keyboardRowBack.add(new KeyboardButton("деканат"));
                keyboardRowBack.add(new KeyboardButton("расписание"));
                keyboardRowBack.add(new KeyboardButton("столовая"));
                keyboardRowBack1.add(new KeyboardButton("обратная связь"));
                keyboardRowBack1.add(new KeyboardButton("общая информция"));
                keyboardRowBack1.add(new KeyboardButton("справки"));

                keyboardRowList.add(keyboardRowBack);
                keyboardRowList.add(keyboardRowBack1);
                break;

            case ("общая информция"):
                keyboardRow.add(new KeyboardButton("оповещения о расписании"));
                keyboardRow.add(new KeyboardButton("расписание работы"));

                keyboardRowList.add(keyboardRow);
                break;
            case ("справки"):
                keyboardRowSprav.add(new KeyboardButton("для студента"));
                keyboardRowSprav.add(new KeyboardButton("в военкомат"));
                keyboardRowSprav.add(new KeyboardButton("о доходах"));
                keyboardRowSprav.add(new KeyboardButton("назад"));

                keyboardRowList.add(keyboardRowSprav);
                break;
            case ("Регистрация пройдена успешно"):

                keyboardRow.add(new KeyboardButton("Отправить сообщение группе"));
                keyboardRow.add(new KeyboardButton("Расписание"));

                keyboardRowList.add(keyboardRow);
                break;

        }
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {
        return "MGRIBOT";
    }

    public String getBotToken() {
        return "1645890038:AAAAAAAAAAAAAAAAAAAAAAAA";
    }

}
