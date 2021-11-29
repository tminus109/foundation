public class DiagonalDifference {
    public static int diagonalDifference(int[][] arr) {
        int leftToRightDiagonal = 0;
        int rightToLeftDiagonal = 0;

        for (int i = 0; i < arr.length; i++) {
            leftToRightDiagonal += arr[i][i];
        }

        int j = arr.length - 1;
        for (int[] ints : arr) {
            rightToLeftDiagonal += ints[j];
            j--;
        }

        return Math.abs(leftToRightDiagonal - rightToLeftDiagonal);
    }

    public static void main(String[] args) {
        int[][] arr0 = {
                {1, 2, 3},
                {4, 5, 6},
                {9, 8, 9}
        };

        int[][] arr1 = {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}
        };

        System.out.println(diagonalDifference(arr0));
        System.out.println(diagonalDifference(arr1));
    }
}
