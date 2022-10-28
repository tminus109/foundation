public class TwoDArray {
    public static int countHighestHourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        int l = arr.length - 2;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int tempSum = arr[i][j] +
                        arr[i][j + 1] +
                        arr[i][j + 2] +
                        arr[i + 1][j + 1] +
                        arr[i + 2][j] +
                        arr[i + 2][j + 1] +
                        arr[i + 2][j + 2];
                if (tempSum > sum) {
                    sum = tempSum;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int[][] input2 = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println(countHighestHourglassSum(input));
        System.out.println(countHighestHourglassSum(input2));
    }
}
