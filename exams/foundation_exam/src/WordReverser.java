public class WordReverser {
    static String reverseWords(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
                stringBuilder.append(words[i].charAt(j));
            }
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        String sentence = "lleW ,enod taht saw ton taht drah";
        System.out.println(reverseWords(sentence));
    }
}
