public class ArmstrongNumber {
    public static String isNumberArmstrong(int n) {
        int armstrong = 0;
        String nStringified = String.valueOf(n);
        for (int i = 0; i < nStringified.length(); i++) {
            armstrong += Math.pow(Character.digit(nStringified.charAt(i), 10), nStringified.length());
        }
        if (armstrong == n) {
            return "The " + n + " is an Armstrong number";
        } else {
            return "The " + n + " is not an Armstrong number";
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumberArmstrong(1634));
        System.out.println(isNumberArmstrong(371));
        System.out.println(isNumberArmstrong(86));
    }
}
