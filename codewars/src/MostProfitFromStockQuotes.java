public class MostProfitFromStockQuotes {
    public static int countMostProfit(int[] quotes) {
        int profit = 0;
        int stockCount = 0;

        for (int i = 0; i < quotes.length; i++) {
            int bestPrice = quotes[i];

            for (int j = (i + 1); j < quotes.length; j++) {
                if (quotes[j] > bestPrice) {
                    bestPrice = quotes[j];
                }
            }

            if (bestPrice > quotes[i]) {
                stockCount++;
                profit -= quotes[i];
            } else if (bestPrice == quotes[i]) {
                profit += stockCount * bestPrice;
                stockCount = 0;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(countMostProfit(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(countMostProfit(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(countMostProfit(new int[]{1, 6, 5, 10, 8, 7}));
        System.out.println(countMostProfit(new int[]{1, 2, 10, 3, 2, 7, 3, 2}));
    }
}
