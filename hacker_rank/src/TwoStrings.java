public class TwoStrings {
    public static String twoStrings(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(String.valueOf(s1.charAt(i)))) {
                return "YES";
            }

//            if (s2.contains(Character.toString(s1.charAt(i)))) {
//                return "YES";
//            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hi";
        String s4 = "world";

        System.out.println(twoStrings(s1, s2));
        System.out.println(twoStrings(s3, s4));
    }
}
