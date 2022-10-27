import java.text.DecimalFormat;

public class PlusMinus {
    public static void calcRatios(int[] arr) {
        DecimalFormat df = new DecimalFormat("0.000000");
        int length = arr.length;
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;

        for (int n : arr) {
            if (n > 0) {
                posCount++;
            } else if (n < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println(df.format((float) posCount / length));
        System.out.println(df.format((float) negCount / length));
        System.out.println(df.format((float) zeroCount / length));
    }

    public static void main(String[] args) {
        calcRatios(new int[]{1, 1, 0, -1, -1});
        calcRatios(new int[]{-4, 3, -9, 0, 4, 1});
    }
}
