import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.HashMap;

public class Register implements Serializable{
    public HashMap<Long, User> longBooleanHashMap = new HashMap<>();
// в класс входит TD и клас возвращяет значение есть пользователь или нет
    public boolean CheckInitialization(long id) {
        return longBooleanHashMap.containsKey(id);

    }

    boolean Registration(long id, String group) throws IOException {

        boolean cons = false;
        User user = new User();
        user.setUserID(id);
        user.setGroup(group);
        FileInputStream fs = new FileInputStream("C:/MyLoveJava/Folder for Data/Gruppy.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        for(int j = 0; j < 6; j++) {
            for (int i = 0; i < 93; i++) {
                try {
                    //System.out.println(String.valueOf(wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue()));
                    if(String.valueOf(wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue()).equals(group)) {
                        user.setFaculty(String.valueOf(wb.getSheetAt(0).getRow(0).getCell(j).getStringCellValue()));
                        cons = true;
                        break;
                    }
                }catch (NullPointerException ignored){

                }
            }
        }

        fs.close();
        longBooleanHashMap.put(id, user);
        System.out.println(longBooleanHashMap.get(id).getFaculty()+"      "+id);
        return cons;

    }

    public String AnserInformation(long id) {
        return "Ваш факультет: "+longBooleanHashMap.get(id).getFaculty();
    }

    public void RemoveUser(long id) {
        longBooleanHashMap.remove(id);
    }

    public void SerializeRegister(Register register) throws IOException {
        FileOutputStream FOS = new FileOutputStream("C:/Bot/Text/Users.txt");
        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        OOS.writeObject(register);
        FOS.close();
        OOS.close();

    }
}
