public class ValidParenthesis {
    public static boolean isParenthesisValid(String s) {
        if (!s.contains("(") || !s.contains(")")) {
            return false;
        }

        int length = s.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String s = "()";
        String s2 = ")(((()))";
        String s3 = "(";
        String s4 = "(())((()())())";
        String s5 = "(()()(()())()";
        String s6 = "()))((";

        System.out.println(isParenthesisValid(s));
        System.out.println(isParenthesisValid(s2));
        System.out.println(isParenthesisValid(s3));
        System.out.println(isParenthesisValid(s4));
        System.out.println(isParenthesisValid(s5));
        System.out.println(isParenthesisValid(s6));
    }
}
