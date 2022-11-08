import java.util.Arrays;

public class CharacterWithLongestConsecutiveRepetition {
    public static Object[] findChar(String s) {
        int length = s.length();

        if (length == 0) {
            return new Object[]{"", 0};
        }

        char c = s.charAt(0);
        int l = 1;

        for (int i = 0; i < length - 1; i++) {
            char ch = s.charAt(i);
            int count = 1;

            for (int j = (i + 1); j < length; j++) {
                if (s.charAt(j) == ch) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > l) {
                c = ch;
                l = count;
            }
        }

        return new Object[]{String.valueOf(c), l};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findChar("alallaamdgg")));
        System.out.println(Arrays.toString(findChar("abcaba")));
        System.out.println(Arrays.toString(findChar("abcabab")));
        System.out.println(Arrays.toString(findChar("babcaba")));
        System.out.println(Arrays.toString(findChar("")));
        System.out.println(Arrays.toString(findChar("aaaabb")));
        System.out.println(Arrays.toString(findChar("bbbaaabaaaa")));
    }
}
