import java.util.Arrays;

public class StringArrayDuplicate {
    public static String[] removeConsecutiveDuplicates(String[] arr) {
        String[] noDuplicates = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);

            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(j - 1)) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }

            noDuplicates[i] = sb.toString();
        }

        return noDuplicates;
    }

    public static void main(String[] args) {
        String[] arr = {"abracadabra", "allottee", "assessee"};
        String[] arr2 = {"kelless", "keenness"};
        String[] arr3 = {"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"};

        System.out.println(Arrays.toString(removeConsecutiveDuplicates(arr)));
        System.out.println(Arrays.toString(removeConsecutiveDuplicates(arr2)));
        System.out.println(Arrays.toString(removeConsecutiveDuplicates(arr3)));
    }
}
