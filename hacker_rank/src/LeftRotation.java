import java.util.Arrays;

public class LeftRotation {
    public static int[] rotLeft(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = temp;
        }
        return a;
    }

    public static int[] rotLeft2(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[0];
            System.arraycopy(a, 1, a, 0, a.length - 1);
            a[a.length - 1] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        int d = 4;

        System.out.println(Arrays.toString(rotLeft2(b, d)));
        System.out.println(Arrays.toString(rotLeft(a, d)));
    }
}
