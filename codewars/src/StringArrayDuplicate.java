import java.util.Arrays;

public class StringArrayDuplicate {
    public static String[] removeDuplicateLetters(String[] arr) {
        String[] output = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(j - 1)) {
                    sb.deleteCharAt(j);
                }
            }
            output[i] = sb.toString();
        }

        return output;
    }

    public static void main(String[] args) {
        String[] arr0 = {"abracadabra", "allottee", "assessee"};
        String[] arr1 = {"kelless", "keenness"};

        System.out.println(Arrays.toString(removeDuplicateLetters(arr0)));
        System.out.println(Arrays.toString(removeDuplicateLetters(arr1)));
    }
}
