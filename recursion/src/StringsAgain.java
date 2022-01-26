public class StringsAgain {
    static String removeX(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            if (s.charAt(s.length() - 1) == 'x') {
                return removeX(s.substring(0, s.length() - 1));
            } else {
                return removeX(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(removeX("xavier Xy"));
    }
}
