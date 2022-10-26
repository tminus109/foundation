public class SimplePigLatin {
    public static String pigIt(String latin) {
        String[] words = latin.split(" ");
        StringBuilder pigLatin = new StringBuilder();

        for (String word : words) {
            int l = word.length() - 1;
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(l);

            pigLatin.append(word, 1, l);

            if (Character.isLetterOrDigit(lastChar)) {
                pigLatin.append(lastChar).append(firstChar).append("ay");
            } else {
                pigLatin.append(firstChar).append("ay").append(lastChar);
            }

            pigLatin.append(" ");
        }

        return pigLatin.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool."));
        System.out.println(pigIt("Hello world!"));
    }
}
