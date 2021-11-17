import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    public static void getAnswers(Map<String, Integer> products) {
        System.out.println(products.get("Fish"));

        String mostExpensiveProduct = "";
        int price = 0;
        for (String key : products.keySet()) {
            if (products.get(key) > price) {
                price = products.get(key);
                mostExpensiveProduct = key;
            }
        }
        System.out.println(mostExpensiveProduct);

        int total = 0;
        for (String key : products.keySet()) {
            total += products.get(key);
        }
        int averagePrice = total / products.size();
        System.out.println(averagePrice);

        int productsWithPriceBelow300 = 0;
        for (String key : products.keySet()) {
            if (products.get(key) < 300) {
                productsWithPriceBelow300++;
            }
        }
        System.out.println(productsWithPriceBelow300);

        ArrayList<String> productsForExactly125 = new ArrayList<>();
        for (String key : products.keySet()) {
            if (products.get(key) == 125) {
                productsForExactly125.add(key);
            }
        }
        System.out.println(productsForExactly125);

        int cheapestPrice = Integer.MAX_VALUE;
        String cheapestProduct = "";
        for (String key : products.keySet()) {
            if (products.get(key) < cheapestPrice) {
                cheapestProduct = key;
            }
        }
        System.out.println(cheapestProduct);
    }

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Eggs", 200);
        products.put("Milk", 200);
        products.put("Fish", 400);
        products.put("Apples", 150);
        products.put("Bread", 50);
        products.put("Chicken", 550);

        getAnswers(products);
    }
}
