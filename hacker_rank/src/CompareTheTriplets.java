import java.util.Arrays;

public class CompareTheTriplets {
    public static int[] compareTriplets(int[] a, int[] b) {
        int[] scores = new int[2];
        int length = a.length;
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < length; i++) {
            if (a[i] > b[i]) {
                scoreA++;
            } else if (a[i] < b[i]) {
                scoreB++;
            }
        }

        scores[0] = scoreA;
        scores[1] = scoreB;

        return scores;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(compareTriplets(new int[]{5, 6, 7}, new int[]{3, 6, 10})));
        System.out.println(Arrays.toString(compareTriplets(new int[]{17, 28, 30}, new int[]{99, 16, 8})));
        System.out.println(Arrays.toString(compareTriplets(new int[]{1, 2, 3}, new int[]{3, 2, 1})));
    }
}
