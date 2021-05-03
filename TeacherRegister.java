import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.HashMap;

public class TeacherRegister implements Serializable {
    public HashMap<Long, TeacherUser> longBooleanHashMap = new HashMap<>();

    public boolean CheckTeacherInitialization(long id) {
        return longBooleanHashMap.containsKey(id);
    }

    boolean Registration(long id, String name) throws IOException {
        boolean cons = false;
        TeacherUser user = new TeacherUser();
        user.setUserID(id);
        user.setName(name);
        FileInputStream fs = new FileInputStream("C:/MyLoveJava/Folder for Data/teach/RaspPreps.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        for (int j = 1; j < 51; j++) {
            for (int i = 4; i < 1000; i += 40) {
                try {
                    if (StringUtils.contains(String.valueOf(wb.getSheetAt(j).getRow(i).getCell(0).getStringCellValue()), name)) {
                        user.setChair(String.valueOf(wb.getSheetAt(j).getRow(2).getCell(0).getStringCellValue()));
                        cons = true;
                        break;
                    }
                } catch (NullPointerException ignored) { }

            }
        }
        fs.close();
        wb.close();
        longBooleanHashMap.put(id, user);
        return cons;
    }

    boolean CheckGroup(String group) throws IOException {
        boolean cons = false;

        FileInputStream fis = new FileInputStream("C:/MyLoveJava/Folder for Data/Gruppy.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);

        AdaptationNameGroupTeacher adaptationNameGroupTeacher = new AdaptationNameGroupTeacher();
        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 93; i++) {
                try {
                    if (wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue().equals(adaptationNameGroupTeacher.Adapter(group))) {
                        cons = true;
                        break;
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }
        fis.close();
        wb.close();
        return cons;
    }

    public String AnswerInformation(long id) {
        return "Ваше имя: " + longBooleanHashMap.get(id).getName() + "\n" + "Кафедра: " + longBooleanHashMap.get(id).getChair();
    }

    public void RemoveUser(long id) {
        longBooleanHashMap.remove(id);
    }

    public void SerializeRegister(TeacherRegister register) throws IOException {
        FileOutputStream FOS = new FileOutputStream("C:/Bot/Text/UsersTeach.txt");
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        OOS.writeObject(register);
        FOS.close();
        OOS.close();

    }
}