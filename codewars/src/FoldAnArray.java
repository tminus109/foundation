import java.util.Arrays;

public class FoldAnArray {
    public static int[] foldArray(int[] array, int folds) {
        int[] arr = Arrays.copyOf(array, array.length);
        int length = arr.length;
        for (int i = 0; i < folds; i++) {
            for (int j = 0; j < length / 2; j++) {
                arr[j] += arr[length - 1 - j];
            }
            length = (length + 1) / 2;
        }
        return Arrays.copyOf(arr, length);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int fold = 1;
        int fold2 = 2;

        System.out.println(Arrays.toString(foldArray(input, fold)));
        System.out.println(Arrays.toString(foldArray(input, fold2)));
    }
}
