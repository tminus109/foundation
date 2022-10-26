public class AlternatingCharacters {
    public static int getAlternatingChars(String s) {
        int deletionCount = 0;
        int index = 0;
        StringBuilder chars = new StringBuilder(s);

        for (int i = 0; i < chars.length() - 1; i++) {
            if (chars.charAt(index) ==
                    chars.charAt(index + 1)) {
                chars.deleteCharAt(index);
                deletionCount++;
                i--;
            } else {
                index++;
            }
        }

        return deletionCount;
    }

    public static void main(String[] args) {
        System.out.println(getAlternatingChars("AAAA"));
        System.out.println(getAlternatingChars("BBBBB"));
        System.out.println(getAlternatingChars("ABABABAB"));
        System.out.println(getAlternatingChars("BABABA"));
        System.out.println(getAlternatingChars("AAABBB"));
    }
}
