public class Anagram {
    public static Boolean isAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        for (int i = 0; i < input1.length(); i++) {
            char c = input1.charAt(i);
            if (input2.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("dog", "god"));
        System.out.println(isAnagram("green", "fox"));
        System.out.println(isAnagram("elbow", "below"));
        System.out.println(isAnagram("rat", "tiger"));
    }
}
