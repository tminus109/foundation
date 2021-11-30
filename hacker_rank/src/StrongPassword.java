public class StrongPassword {
    public static int minimumNumber(String password) {
        int count = 0;
        int charDifference = 6 - password.length();

        if (!password.matches(".*[a-z].*")) {
            count++;
        }
        if (!password.matches(".*[A-Z].*")) {
            count++;
        }
        if (!password.matches(".*[0-9].*")) {
            count++;
        }
        if (!password.matches(".*[!@#$%^&*()-+].*")) {
            count++;
        }
        if (charDifference > 0 && count < charDifference) {
            return charDifference;
        }
        return count;
    }

    public static void main(String[] args) {
        String password0 = "Ab1";
        String password1 = "#HackerRank";
        String password2 = "2bbbb";
        String password3 = "2bb#A";

        System.out.println(minimumNumber(password0));
        System.out.println(minimumNumber(password1));
        System.out.println(minimumNumber(password2));
        System.out.println(minimumNumber(password3));
    }
}
