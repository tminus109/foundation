public class TwoStrings {
    public static String compareStrings(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i)))) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("hello", "world"));
        System.out.println(compareStrings("hi", "world"));
    }
}
