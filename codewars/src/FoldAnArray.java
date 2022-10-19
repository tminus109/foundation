import java.util.Arrays;

public class FoldAnArray {
    public static int[] foldArray(int[] array, int foldCount) {
        int[] foldedArray = Arrays.copyOf(array, array.length);
        int length = foldedArray.length;
        for (int i = 0; i < foldCount; i++) {
            for (int j = 0; j < length / 2; j++) {
                foldedArray[j] += foldedArray[length - 1 - j];
            }
            length = (length + 1) / 2;
        }
        return Arrays.copyOf(foldedArray, length);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(foldArray(array, 1)));
        System.out.println(Arrays.toString(foldArray(array, 2)));
    }
}
