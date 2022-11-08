import java.util.Arrays;

public class AreTheyTheSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        int[] sortedA = Arrays.stream(a).map(i -> i * i).sorted().toArray();
        int[] sortedB = Arrays.stream(b).sorted().toArray();

        return Arrays.equals(sortedA, sortedB);
    }

    public static void main(String[] args) {
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        int[] a2 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b2 = {11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19};
        int[] a3 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b3 = {132, 14641, 20736, 361, 25921, 361, 20736, 361};
        int[] a4 = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b4 = {121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        int[] a5 = {41, 73, 23, 80, 29, 54, 52, 41, 8, 17, 75, 24, 80, 0, 47, 96, 16};
        int[] b5 = {1681, 5329, 529, 6400, 841, 2916, 2704, 1681, 64, 289, 5625, 576, 6400, 0, 2209, 9216, 256,};
        int[] a6 = {121, -144, 19, 161, 19, 144, 19, 11};
        int[] b6 = {121, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(comp(a, b));
        System.out.println(comp(a2, b2));
        System.out.println(comp(a3, b3));
        System.out.println(comp(a4, b4));
        System.out.println(comp(a5, b5));
        System.out.println(comp(a6, b6));
    }
}
