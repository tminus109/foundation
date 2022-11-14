import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RansomNote {
    public static void matchWords(String[] magazine, String[] note) {
        List<String> magazineList = new ArrayList<>(Arrays.asList(magazine));

        for (String s : note) {
            if (!magazineList.contains(s)) {
                System.out.println("No");
                return;
            } else {
                magazineList.remove(s);
            }
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        matchWords(new String[]{"give", "me", "one", "grand", "today", "night"}, new String[]{"give", "one", "grand", "today"});
        matchWords(new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two", "times", "three", "is", "not", "four"});
        matchWords(new String[]{"attack", "at", "dawn"}, new String[]{"Attack", "at", "dawn"});
        matchWords(new String[]{"two", "times", "three", "is", "not", "four"}, new String[]{"two", "times", "two", "is", "four"});
    }
}
