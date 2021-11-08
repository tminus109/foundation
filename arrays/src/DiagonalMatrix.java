import java.util.Arrays;

public class DiagonalMatrix {
    public static void main(String[] args) {
        int length = 4;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i] == matrix[j]) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
