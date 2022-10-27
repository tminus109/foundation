public class CamelCase {
    public static int countWords(String s) {
        String[] words = s.split("[A-Z]");

        return words.length;
    }

    public static void main(String[] args) {
        System.out.println(countWords("oneTwoThree"));
        System.out.println(countWords("saveChangesInTheEditor"));
    }
}
