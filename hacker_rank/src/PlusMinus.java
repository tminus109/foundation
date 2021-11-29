import java.text.DecimalFormat;

public class PlusMinus {
    public static void plusMinus(int[] arr) {
        DecimalFormat df = new DecimalFormat("0.000000");
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        int zeroes = 0;

        for (int j : arr) {
            if (j > 0) {
                positiveNumbers++;
            } else if (j < 0) {
                negativeNumbers++;
            } else {
                zeroes++;
            }
        }

        System.out.println(df.format((float) positiveNumbers / arr.length));
        System.out.println(df.format((float) negativeNumbers / arr.length));
        System.out.println(df.format((float) zeroes / arr.length));
    }

    public static void main(String[] args) {
        int[] arr0 = {1, 1, 0, -1, -1};
        int[] arr1 = {-4, 3, -9, 0, 4, 1};

        plusMinus(arr0);
        plusMinus(arr1);
    }
}
