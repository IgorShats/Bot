import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;

//тут парсица расписание, оно же и возвращается
public class ExelPars {
    String[] chars = {"9:30-11:05", ""};

    public String readWorkbook(String filename) {

        String str = "";
        try {
            FileInputStream fs = new FileInputStream(filename);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            Date data = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(data);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            System.out.println(dayOfWeek);


            for (int i = 1; i < 20; i++) {
                i++;
                str = str + wb.getSheetAt(0).getRow(i).getCell(dayOfWeek).getStringCellValue() + "\n";

            }
            fs.close();
            wb.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
