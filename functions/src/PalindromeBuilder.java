public class PalindromeBuilder {
    public static String palindromeBuilder1(String input) {
        StringBuilder reversedInput = new StringBuilder();
        char c;
        for (int i = input.length() - 1; i >= 0; i--) {
            c = input.charAt(i);
            reversedInput.append(c);
        }
        return input + reversedInput;
    }

    public static String palindromeBuilder2(String input) {
        StringBuilder output = new StringBuilder(input);
        return input + output.reverse();
    }

    public static void main(String[] args) {
        System.out.println(palindromeBuilder1("rat"));
        System.out.println(palindromeBuilder2("rat"));
    }
}
