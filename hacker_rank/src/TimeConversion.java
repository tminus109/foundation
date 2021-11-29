import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
    public static String timeConversion(String s) {
        String militaryTime = "";
        try {
            DateFormat input = new SimpleDateFormat("hh:mm:ssa");
            DateFormat output = new SimpleDateFormat("HH:mm:ss");
            Date inputTime = input.parse(s);
            militaryTime = output.format(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return militaryTime;
    }

    public static void main(String[] args) throws ParseException {
        String s0 = "12:01:00PM";
        String s1 = "12:01:00AM";
        String s2 = "07:05:45PM";

        System.out.println(timeConversion(s0));
        System.out.println(timeConversion(s1));
        System.out.println(timeConversion(s2));
    }
}
