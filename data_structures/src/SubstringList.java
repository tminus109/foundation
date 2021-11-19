public class SubstringList {
    public static int findIndex(String word, String[] searchArr) {
        for (int i = 0; i < searchArr.length; i++) {
            if (searchArr[i].toLowerCase().contains(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] searchArr = new String[]{"this", "is", "what", "I'm", "searching"};
        String word = "ching";
        String word2 = "not";

        System.out.println(findIndex(word, searchArr));
        System.out.println(findIndex(word2, searchArr));
    }
}
