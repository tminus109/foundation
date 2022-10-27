public class DiagonalDifference {
    public static int countDiagonalDiff(int[][] arr) {
        int sumLeft = 0;
        int sumRight = 0;
        int length = arr.length;
        int j = length - 1;

        for (int i = 0; i < length; i++) {
            sumLeft += arr[i][i];
            sumRight += arr[i][j];
            j--;
        }

        return Math.abs(sumLeft - sumRight);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        };

        int[][] arr2 = {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}
        };

        System.out.println(countDiagonalDiff(arr));
        System.out.println(countDiagonalDiff(arr2));
    }
}
