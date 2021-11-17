import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
    public static void productsThatCostLessThan201(Map<String, Integer> products) {
        ArrayList<String> productsThatCostLessThan201 = new ArrayList<>();
        for (String key : products.keySet()) {
            if (products.get(key) < 201) {
                productsThatCostLessThan201.add(key);
            }
        }
        System.out.println(productsThatCostLessThan201);
    }

    public static void productsThatCostMoreThan150(Map<String, Integer> products) {
        ArrayList<String> productsThatCostLessThan201 = new ArrayList<>();
        for (String key : products.keySet()) {
            if (products.get(key) > 150) {
                productsThatCostLessThan201.add(key + " " + products.get(key));
            }
        }
        System.out.println(productsThatCostLessThan201);
    }

    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Eggs", 200);
        products.put("Milk", 200);
        products.put("Fish", 400);
        products.put("Apples", 150);
        products.put("Bread", 50);
        products.put("Chicken", 550);

        productsThatCostLessThan201(products);
        productsThatCostMoreThan150(products);
    }
}
