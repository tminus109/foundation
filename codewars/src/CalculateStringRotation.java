public class CalculateStringRotation {
    public static int calculateStringRotation(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return -1;
        }

        if (string1.equals(string2)) {
            return 0;
        }

        for (int i = 0, l = string1.length(); i < l; i++) {
            if (string1.charAt(i) == string2.charAt(0)) {
                String substring1 = string1.substring(i);
                String substring2 = string1.substring(0, i);
                if (substring1.concat(substring2).equals(string2)) {
                    return substring1.length();
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(calculateStringRotation("fatigue", "tiguefa"));
        System.out.println(calculateStringRotation("coffee", "eecoff"));
        System.out.println(calculateStringRotation("eecoff", "coffee"));
        System.out.println(calculateStringRotation("moose", "Moose"));
        System.out.println(calculateStringRotation("isn't", "'tisn"));
        System.out.println(calculateStringRotation("Esham", "Esham"));
        System.out.println(calculateStringRotation("Esham", "esham"));
        System.out.println(calculateStringRotation("dog", "god"));
        System.out.println(calculateStringRotation("mami", "mima"));
        System.out.println(calculateStringRotation("m", "mmm"));
    }
}
