public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        int minimumNumberOfDeletions = 0;
        StringBuilder noMatchingAdjacentCharacters = new StringBuilder(s);
        int index = 0;

        for (int i = 0; i < noMatchingAdjacentCharacters.length() - 1; i++) {
            if (noMatchingAdjacentCharacters.charAt(index) ==
                    noMatchingAdjacentCharacters.charAt(index + 1)) {
                noMatchingAdjacentCharacters.deleteCharAt(index);
                minimumNumberOfDeletions++;
                i--;
            } else {
                index++;
            }
        }

        return minimumNumberOfDeletions;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        String s2 = "BBBBB";
        String s3 = "ABABABAB";
        String s4 = "BABABA";
        String s5 = "AAABBB";

        System.out.println(alternatingCharacters(s));
        System.out.println(alternatingCharacters(s2));
        System.out.println(alternatingCharacters(s3));
        System.out.println(alternatingCharacters(s4));
        System.out.println(alternatingCharacters(s5));
    }
}
