import java.util.ArrayList;
import java.util.List;

public class CharacterWithLongestConsecutiveRepetition {
    public static List<Object> findChar(String s) {
        List<Object> output = new ArrayList<>();
        int length = s.length();

        if (length == 0) {
            output.add("\"\"");
            output.add(0);
            return output;
        }

        char c = s.charAt(0);
        int l = 1;

        for (int i = 0; i < length - 1; i++) {
            char ch = s.charAt(i);
            int count = 1;

            for (int j = (i + 1); j < length; j++) {
                if (s.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > l) {
                c = ch;
                l = count;
            }
        }

        output.add(c);
        output.add(l);

        return output;
    }

    public static void main(String[] args) {
        System.out.println(findChar("alallaamdgg"));
        System.out.println(findChar("abcaba"));
        System.out.println(findChar("abcabab"));
        System.out.println(findChar("babcaba"));
        System.out.println(findChar(""));
    }
}
