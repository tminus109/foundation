import java.util.Arrays;

public class CompareTheTriplets {
    public static int[] compareTriplets(int[] a, int[] b) {
        int[] scores = new int[2];
        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < a.length; i++) {
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
        int[] a0 = {5, 6, 7};
        int[] b0 = {3, 6, 10};

        int[] a1 = {17, 28, 30};
        int[] b1 = {99, 16, 8};

        int[] a2 = {1, 2, 3};
        int[] b2 = {3, 2, 1};

        System.out.println(Arrays.toString(compareTriplets(a0, b0)));
        System.out.println(Arrays.toString(compareTriplets(a1, b1)));
        System.out.println(Arrays.toString(compareTriplets(a2, b2)));
    }
}
