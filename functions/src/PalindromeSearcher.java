import java.util.ArrayList;

public class PalindromeSearcher {
    public static boolean isPalindrom(String input) {
        int index = input.length() - 1;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(index)) {
                return false;
            } else {
                index--;
            }
        }
        return true;
    }

    public static ArrayList searchPalindrome(String input) {
        String palindrome = "";
        ArrayList palindromes = new ArrayList();
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = index; j < input.length(); j++) {
                palindrome += input.charAt(j);
                if (palindrome.length() >= 3 && isPalindrom(palindrome)) {
                    palindromes.add(palindrome);
                }
            }
            palindrome = "";
            index++;
        }
        return palindromes;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom("panam"));
        System.out.println(isPalindrom("pannap"));
        System.out.println(searchPalindrome("dog goat dad duck doodle never"));
        System.out.println(searchPalindrome("apple"));
        System.out.println(searchPalindrome("racecar"));
    }
}
