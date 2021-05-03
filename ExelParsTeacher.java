import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//тут парсица расписание, оно же и возвращается
public class ExelParsTeacher {

    public String readWorkbook(String TeacherName) throws IOException {
        System.out.println("ffdfdf");
        String str = "";
        Date data = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("MOW"));
        System.out.println(data.getHours());
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-1;

        FileInputStream fs = new FileInputStream("C:/Users/Igor/OneDrive/Катюша/Игорь/MyLoveJava/Folder for Data/teach/RaspPreps.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        for (int j = 1; j < 51; j++) {
            for (int i = 4; i < 1000; i += 40) {
                try {

                    if (StringUtils.contains(String.valueOf(wb.getSheetAt(j).getRow(i).getCell(0).getStringCellValue()), TeacherName)) {

                        System.out.println(dayOfWeek);
                        if (dayOfWeek == 1) {
                            if (isEvenWeek(data)) {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(2).getStringCellValue()+"\n"+"Аудитория:      "+wb.getSheetAt(j).getRow(i+6).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+10).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+14).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+18).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+22).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+26).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+30).getCell(3).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(2).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(3).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(2).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(3).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(2).getStringCellValue()+"\n"+"Аудитория:      "+wb.getSheetAt(j).getRow(i+8).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+12).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+16).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+20).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+24).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+28).getCell(3).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(2).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+32).getCell(3).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(2).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(3).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(2).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(2).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(3).getStringCellValue()+"\n";

                            }
                        } else if (dayOfWeek == 2) {
                            if (isEvenWeek(data)) {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+6).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+10).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+14).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+18).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+22).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+26).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+30).getCell(5).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(4).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(5).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(4).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(5).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+8).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+12).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+16).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+20).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+24).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+28).getCell(5).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(4).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+32).getCell(5).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(4).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(5).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(4).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(4).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(5).getStringCellValue()+"\n";
                            }

                        } else if (dayOfWeek == 3) {
                            if (isEvenWeek(data)) {
                                System.out.println("gfgdfg");
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+6).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+10).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+14).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+18).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+22).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+26).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+30).getCell(7).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(6).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(7).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(6).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(7).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+8).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+12).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+16).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+20).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+24).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+28).getCell(7).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(6).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+32).getCell(7).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(6).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(7).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(6).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(6).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(7).getStringCellValue()+"\n";
                            }

                        } else if (dayOfWeek == 4) {
                            if (isEvenWeek(data)) {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(8).getStringCellValue()+"\n"+"Аудитория:      "+wb.getSheetAt(j).getRow(i+6).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+10).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+14).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+18).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+22).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+26).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+30).getCell(9).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(8).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(9).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(8).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(9).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(8).getStringCellValue()+"\n"+"Аудитория:      "+wb.getSheetAt(j).getRow(i+8).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+12).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+16).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+20).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+24).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+28).getCell(9).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(8).getStringCellValue()+"\n"+"Аудитория:       "+wb.getSheetAt(j).getRow(i+32).getCell(9).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(8).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(9).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(8).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(8).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(9).getStringCellValue()+"\n";
                            }

                        } else if (dayOfWeek == 5) {
                            if (isEvenWeek(data)) {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+6).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+10).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+14).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+18).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+22).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+26).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+30).getCell(11).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(10).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(11).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(10).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(11).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+8).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+12).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+16).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+20).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+24).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+28).getCell(11).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(10).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+32).getCell(11).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(10).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(11).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(10).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(10).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(11).getStringCellValue()+"\n";
                            }

                        } else if (dayOfWeek == 6) {
                            if (isEvenWeek(data)) {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+6).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+7).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+6).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+10).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+11).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+10).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+14).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+15).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+14).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+18).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+19).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+18).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+22).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+23).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+22).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+26).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+27).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+26).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+30).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+31).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+30).getCell(13).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+34).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+34).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+35).getCell(12).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+34).getCell(13).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+38).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+38).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+39).getCell(12).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+38).getCell(13).getStringCellValue()+"\n";
                            } else {
                                str += wb.getSheetAt(j).getRow(i+6).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+8).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+9).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+8).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+10).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+12).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+13).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+12).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+14).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+16).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+17).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+16).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+18).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+20).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+21).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+20).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+22).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+24).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+25).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+24).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+26).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+28).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+29).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+28).getCell(13).getStringCellValue()+"\n"+"\n";
                                str += wb.getSheetAt(j).getRow(i+30).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+32).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+33).getCell(12).getStringCellValue()+"\n"+"Аудитория:     "+wb.getSheetAt(j).getRow(i+32).getCell(13).getStringCellValue()+"\n"+"\n";
//                                str += wb.getSheetAt(j).getRow(i+36).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+36).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+37).getCell(12).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+36).getCell(13).getStringCellValue()+"\n";
//                                str += wb.getSheetAt(j).getRow(i+40).getCell(1).getStringCellValue()+":    "+wb.getSheetAt(j).getRow(i+40).getCell(12).getStringCellValue()+" "+wb.getSheetAt(j).getRow(i+41).getCell(12).getStringCellValue()+"\n"+wb.getSheetAt(j).getRow(i+40).getCell(13).getStringCellValue()+"\n";
                            }

                        }
                        break;
                    }
                } catch (NullPointerException | ParseException ignored) {

                }
            }
        }

        fs.close();
        System.out.println(str);
        if(str.equals("")){
            return null;
        }else
            return str;
    }


    public static boolean isEvenWeek(Date date) throws ParseException {
        int month = date.getMonth() + 1;
        int year = month > 0 && month < 9 ? date.getYear() - 1 : date.getYear();
        Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse("01.09." + year);

        int numberStartWeek = Integer.parseInt(new SimpleDateFormat("w").format(startDate));
        int numberNowWeek = Integer.parseInt(new SimpleDateFormat("w").format(date));

        int countWeeks = 0;
        if (month > 0 && month < 9) {
            Date lastDateYear = new SimpleDateFormat("dd.MM.yyyy").parse("31.12." + year);
            if (!(new SimpleDateFormat("E").format(lastDateYear).equals("Пн"))) {
                numberNowWeek--;
            }
            countWeeks = Integer.parseInt(new SimpleDateFormat("w").format(lastDateYear)) -
                    numberStartWeek + numberNowWeek;
        } else {
            countWeeks = numberNowWeek - numberStartWeek;
        }
        return countWeeks % 2 != 0;
    }


}
