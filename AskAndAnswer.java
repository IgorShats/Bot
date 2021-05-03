import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class AskAndAnswer {

    HashMap<String, Object> AskAndAnswer = new HashMap<>();

    HashMap<String, Object> initializer(String groupName) throws Exception {

        System.out.println("C:/MyLoveJava/Folder for Data/"+groupName+".xls");
        File file = new File(("C:/MyLoveJava/Folder for Data/"+groupName+".xls"));

        FileInputStream fs = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < 1023; i++) {
            try {
                System.out.println(i);
                AskAndAnswer.put(wb.getSheetAt(0).getRow(i).getCell(0).toString(), wb.getSheetAt(0).getRow(i).getCell(1).toString());
            } catch (Exception e) {
                return AskAndAnswer;
            }
        }
        fs.close();
        wb.close();
        System.out.println("-----------------------------------------------------------------------------------------");
        return AskAndAnswer;
    }
}
