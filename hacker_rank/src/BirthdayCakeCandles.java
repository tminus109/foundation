public class BirthdayCakeCandles {
    public static int countTallestCandles(int[] candles) {
        int tallestCandleCount = 1;
        int tallestCandle = candles[0];

        for (int i = 1, l = candles.length; i < l; i++) {
            int candle = candles[i];
            if (candle > tallestCandle) {
                tallestCandle = candle;
                tallestCandleCount = 1;
            } else if (candle == tallestCandle) {
                tallestCandleCount++;
            }
        }

        return tallestCandleCount;
    }

    public static void main(String[] args) {
        System.out.println(countTallestCandles(new int[]{4, 4, 1, 3}));
        System.out.println(countTallestCandles(new int[]{3, 2, 1, 3}));
        System.out.println(countTallestCandles(new int[]{3, 3, 3, 4, 5, 7, 6, 4, 2, 8, 4, 4, 8, 8, 8}));
        System.out.println(countTallestCandles(new int[]{3, 3, 3, 4, 5, 7, 6, 4, 2, 8, 4, 4, 8, 9, 8}));
    }
}
