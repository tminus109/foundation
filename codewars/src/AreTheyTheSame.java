import java.util.Arrays;

public class AreTheyTheSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != Math.sqrt(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a1 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b1 = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        int[] a2 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b2 = {11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19};
        int[] a3 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b3 = {132, 14641, 20736, 361, 25921, 361, 20736, 361};
        int[] a4 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b4 = {121, 14641, 20736, 36100, 25921, 361, 20736, 361};

        System.out.println(comp(a1, b1));
        System.out.println(comp(a2, b2));
        System.out.println(comp(a3, b3));
        System.out.println(comp(a4, b4));
    }
}
