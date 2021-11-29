public class BirthdayCakeCandles {
    public static int birthdayCakeCandles(int[] candles) {
        int tallestCandlesCount = 0;
        int height = 0;
        for (int candle : candles) {
            if (candle > height) {
                height = candle;
                tallestCandlesCount = 1;
            } else if (candle == height) {
                tallestCandlesCount++;
            }
        }
        return tallestCandlesCount;
    }

    public static void main(String[] args) {
        int[] candles0 = {4, 4, 1, 3};
        int[] candles1 = {3, 2, 1, 3};
        int[] candles2 = {3, 3, 3, 4, 5, 7, 6, 4, 2, 8, 4, 4, 8, 8, 9, 8};

        System.out.println(birthdayCakeCandles(candles0));
        System.out.println(birthdayCakeCandles(candles1));
        System.out.println(birthdayCakeCandles(candles2));
    }
}
