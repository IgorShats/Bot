import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdaptationNameGroup {

    String Adapter(String nameGroup){

        StringBuilder res = new StringBuilder();
        StringBuilder str = new StringBuilder();

        Pattern pattern = Pattern.compile("[А-Яа-я]");
        Matcher matcher = pattern.matcher(nameGroup);

        while (matcher.find())
            res.append(nameGroup.substring(matcher.start(), matcher.end()));

        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(nameGroup);
        while (m.find())
            str.append(nameGroup.substring(m.start(), m.end()));

        System.out.println(res.toString().toUpperCase());
        return res.toString().toUpperCase()+"-"+ str.toString().toUpperCase();

    }
}
