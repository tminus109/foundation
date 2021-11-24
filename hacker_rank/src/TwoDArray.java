public class TwoDArray {
    public static int hourglassSum(int[][] input) {
        int maxHourglassSum = Integer.MIN_VALUE;
        int length = input.length - 2;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temporary = input[i][j] +
                        input[i][j + 1] +
                        input[i][j + 2] +
                        input[i + 1][j + 1] +
                        input[i + 2][j] +
                        input[i + 2][j + 1] +
                        input[i + 2][j + 2];
                if (temporary > maxHourglassSum) {
                    maxHourglassSum = temporary;
                }
            }
        }

        return maxHourglassSum;
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][]{
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

        System.out.println(hourglassSum(input1));
        System.out.println(hourglassSum(input2));
    }
}
