import java.util.ArrayList;
import java.util.List;

public class CharacterWithLongestConsecutiveRepetition {
    public static List<Object> findCharacter(String s) {
        List<Object> output = new ArrayList<>();
        char c = s.charAt(0);
        int l = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int count = 1;
            for (int j = (i + 1); j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > l) {
                c = s.charAt(i);
                l = count;
            }
        }

        output.add(c);
        output.add(l);

        return output;
    }

    public static void main(String[] args) {
        String input1 = "abbcccdddeeeffffafffff";
        System.out.println(findCharacter(input1));
    }
}
