public class StringsAgainAndAgain {
    static String insertAsterisks(String s) {
        if (s.length() == 1) {
            return String.valueOf(s.charAt(0));
        } else {
            return s.charAt(0) + "*" + insertAsterisks(s.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(insertAsterisks("word"));
    }
}
