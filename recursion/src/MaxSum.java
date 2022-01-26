import java.util.Arrays;

public class MaxSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(findMaxSum(array));
    }

    static int findMaxSum(int[] array) {
        int smallestElement;

        if (array.length == 1) {
            return 0;
        }

        if (array[0] < array[1]) {
            smallestElement = array[0];
            array[0] = array[1];
            array[1] = smallestElement;
        }

        return array[0] + findMaxSum(Arrays.copyOfRange(array, 1, array.length));
    }
}
