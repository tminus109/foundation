public class SuperReducedString {
    public static String superReducedString(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.delete(i - 1, i + 1);
                i = 0;
            }
        }

        if (sb.length() == 0) {
            return "Empty String";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String s0 = "aaabccddd";
        String s1 = "aa";
        String s2 = "baab";
        String s3 = "aab";
        String s4 = "abba";

        System.out.println(superReducedString(s0));
        System.out.println(superReducedString(s1));
        System.out.println(superReducedString(s2));
        System.out.println(superReducedString(s3));
        System.out.println(superReducedString(s4));
    }
}
