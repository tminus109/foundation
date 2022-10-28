import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
    public static String convertTime(String s) {
        String militaryTime = "";

        try {
            DateFormat standardTimeFormat = new SimpleDateFormat("hh:mm:ssa");
            Date standardTime = standardTimeFormat.parse(s);
            DateFormat militaryTimeFormat = new SimpleDateFormat("HH:mm:ss");
            militaryTime = militaryTimeFormat.format(standardTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return militaryTime;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(convertTime("12:01:00PM"));
        System.out.println(convertTime("12:01:00AM"));
        System.out.println(convertTime("07:05:45PM"));
    }
}
