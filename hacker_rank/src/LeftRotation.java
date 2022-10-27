import java.util.Arrays;

public class LeftRotation {
    public static int[] rotLeft(int n, int[] arr) {
        int l = arr.length - 1;

        for (int i = 0; i < n; i++) {
            int temp = arr[0];
            System.arraycopy(arr, 1, arr, 0, l);
            arr[l] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(1, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rotLeft(2, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rotLeft(3, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rotLeft(4, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(rotLeft(5, new int[]{1, 2, 3, 4, 5})));
    }
}
