public class SuperReducedString {
    public static String reduceString(String s) {
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
        System.out.println(reduceString("ffcaaabccddd"));
        System.out.println(reduceString("aa"));
        System.out.println(reduceString("baab"));
        System.out.println(reduceString("aab"));
        System.out.println(reduceString("abba"));
    }
}
