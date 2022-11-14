public class StrongPassword {
    public static int checkPasswordStrength(String password) {
        int count = 0;
        int missCharCount = 6 - password.length();

        if (!password.matches(".*[a-z].*")) {
            count++;
        }

        if (!password.matches(".*[A-Z].*")) {
            count++;
        }

        if (!password.matches(".*[0-9].*")) {
            count++;
        }

        if (!password.matches(".*[!@#$%^&*()+-].*")) {
            count++;
        }

        return Math.max(count, missCharCount);
    }

    public static void main(String[] args) {
        System.out.println(checkPasswordStrength("Ab1"));
        System.out.println(checkPasswordStrength("#HackerRank"));
        System.out.println(checkPasswordStrength("AUzs-nV"));
        System.out.println(checkPasswordStrength("2bb#A"));
    }
}
