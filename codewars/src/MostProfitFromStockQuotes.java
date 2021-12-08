public class MostProfitFromStockQuotes {
    public static int mostProfit(int[] quotes) {
        int maxProfit = 0;
        int stock = 0;

        for (int i = 0; i < quotes.length - 1; i++) {
            int bestPrice = quotes[i];
            for (int j = (i + 1); j < quotes.length; j++) {
                if (quotes[j] > bestPrice) {
                    bestPrice = quotes[j];
                }
            }
            if (bestPrice > quotes[i]) {
                stock++;
                maxProfit -= quotes[i];
            } else if (bestPrice == quotes[i]) {
                maxProfit += stock * bestPrice;
                stock = 0;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] quotes1 = {1, 2, 3, 4, 5, 6};
        int[] quotes2 = {6, 5, 4, 3, 2, 1};
        int[] quotes3 = {1, 6, 5, 10, 8, 7};
        int[] quotes4 = {1, 2, 10, 3, 2, 7, 3, 2};

        System.out.println(mostProfit(quotes1));
        System.out.println(mostProfit(quotes2));
        System.out.println(mostProfit(quotes3));
        System.out.println(mostProfit(quotes4));
    }
}
