public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        StringBuilder chars = new StringBuilder(s);
        int index = 0;

        for (int i = 0; i < chars.length() - 1; i++) {
            if (chars.charAt(index) ==
                    chars.charAt(index + 1)) {
                chars.deleteCharAt(index);
                deletions++;
                i--;
            } else {
                index++;
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        String s2 = "BBBBB";
        String s3 = "ABABABAB";
        String s4 = "BABABA";
        String s5 = "AAABBB";

        System.out.println(alternatingCharacters(s));
        System.out.println(alternatingCharacters(s2));
        System.out.println(alternatingCharacters(s3));
        System.out.println(alternatingCharacters(s4));
        System.out.println(alternatingCharacters(s5));
    }
}
