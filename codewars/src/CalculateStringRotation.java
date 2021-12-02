public class CalculateStringRotation {
    public static int calculateStringRotation(String s0, String s1) {
        int output = -1;

        if (s0.length() != s1.length()) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s0.length(); i++) {
            if (s0.charAt(0) == s1.charAt(i)) {
                output = i;
                sb.append(s0.substring(s0.length() - i)).append(s0.substring(0, s0.length() - i));
                break;
            }
        }

        if (sb.toString().equals(s1)) {
            return output;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String s0 = "fatigue";
        String s1 = "tiguefa";
        String s2 = "coffee";
        String s3 = "eecoff";
        String s4 = "eecoff";
        String s5 = "coffee";
        String s6 = "moose";
        String s7 = "Moose";
        String s8 = "isn't";
        String s9 = "'tisn";
        String s10 = "Esham";
        String s11 = "Esham";
        String s12 = "dog";
        String s13 = "god";

        System.out.println(calculateStringRotation(s0, s1));
        System.out.println(calculateStringRotation(s2, s3));
        System.out.println(calculateStringRotation(s4, s5));
        System.out.println(calculateStringRotation(s6, s7));
        System.out.println(calculateStringRotation(s8, s9));
        System.out.println(calculateStringRotation(s10, s11));
        System.out.println(calculateStringRotation(s12, s13));
    }
}
