public class Strings {
    static String changeXToY(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            if (s.charAt(s.length() - 1) == 'x') {
                return changeXToY(s.substring(0, s.length() - 1)) + 'y';
            } else {
                return changeXToY(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "xavier Xy";
        System.out.println(changeXToY(s));
    }
}
