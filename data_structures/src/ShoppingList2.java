import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
    public static void getAnswers() {
        Map<String, Double> priceList = new HashMap<>();
        priceList.put("Milk", 1.07);
        priceList.put("Rice", 1.59);
        priceList.put("Eggs", 3.14);
        priceList.put("Cheese", 12.60);
        priceList.put("Chicken Breasts", 9.40);
        priceList.put("Apples", 2.31);
        priceList.put("Tomato", 2.58);
        priceList.put("Potato", 1.75);
        priceList.put("Onion", 1.10);

        Map<String, Integer> shoppingListOfBob = new HashMap<>();
        shoppingListOfBob.put("Milk", 3);
        shoppingListOfBob.put("Rice", 2);
        shoppingListOfBob.put("Eggs", 2);
        shoppingListOfBob.put("Cheese", 1);
        shoppingListOfBob.put("Chicken Breasts", 4);
        shoppingListOfBob.put("Apples", 1);
        shoppingListOfBob.put("Tomato", 2);
        shoppingListOfBob.put("Potato", 1);

        Map<String, Integer> shoppingListOfAlice = new HashMap<>();
        shoppingListOfAlice.put("Rice", 1);
        shoppingListOfAlice.put("Eggs", 5);
        shoppingListOfAlice.put("Chicken Breasts", 2);
        shoppingListOfAlice.put("Apples", 1);
        shoppingListOfAlice.put("Tomato", 10);

        double bobPays = 0;
        for (Map.Entry<String, Integer> entry : shoppingListOfBob.entrySet()) {
            bobPays += entry.getValue() * priceList.get(entry.getKey());
        }
        System.out.println(bobPays);

        double alicePays = 0;
        for (Map.Entry<String, Integer> entry : shoppingListOfAlice.entrySet()) {
            alicePays += entry.getValue() * priceList.get(entry.getKey());
        }
        System.out.println(alicePays);

        if (!shoppingListOfAlice.containsKey("Eggs") && !shoppingListOfBob.containsKey("Eggs")) {
            System.out.println("no one buys this item");
        } else if (!shoppingListOfAlice.containsKey("Eggs") && shoppingListOfBob.containsKey("Eggs")) {
            System.out.println("Bob");
        } else if (shoppingListOfAlice.containsKey("Eggs") && !shoppingListOfBob.containsKey("Eggs")) {
            System.out.println("Alice");
        } else {
            if (shoppingListOfAlice.get("Eggs") > shoppingListOfBob.get("Eggs")) {
                System.out.println("Alice");
            } else if (shoppingListOfAlice.get("Eggs") < shoppingListOfBob.get("Eggs")) {
                System.out.println("Bob");
            } else {
                System.out.println("equal");
            }
        }

        if (!shoppingListOfAlice.containsKey("Potato") && !shoppingListOfBob.containsKey("Potato")) {
            System.out.println("no one buys this item");
        } else if (!shoppingListOfAlice.containsKey("Potato") && shoppingListOfBob.containsKey("Potato")) {
            System.out.println("Bob");
        } else if (shoppingListOfAlice.containsKey("Potato") && !shoppingListOfBob.containsKey("Potato")) {
            System.out.println("Alice");
        } else {
            if (shoppingListOfAlice.get("Potato") > shoppingListOfBob.get("Potato")) {
                System.out.println("Alice");
            } else if (shoppingListOfAlice.get("Potato") < shoppingListOfBob.get("Potato")) {
                System.out.println("Bob");
            } else {
                System.out.println("equal");
            }
        }

        if (shoppingListOfAlice.size() > shoppingListOfBob.size()) {
            System.out.println("Alice");
        } else if (shoppingListOfAlice.size() < shoppingListOfBob.size()) {
            System.out.println("Bob");
        } else {
            System.out.println("equal");
        }

        int totalPiecesOfBob = 0;
        int totalPiecesOfAlice = 0;
        for (String key : shoppingListOfBob.keySet()) {
            totalPiecesOfBob += shoppingListOfBob.get(key);
        }
        for (String key : shoppingListOfAlice.keySet()) {
            totalPiecesOfAlice += shoppingListOfAlice.get(key);
        }
        if (totalPiecesOfAlice > totalPiecesOfBob) {
            System.out.println("Alice");
        } else if (totalPiecesOfAlice < totalPiecesOfBob) {
            System.out.println("Bob");
        } else {
            System.out.println("equal");
        }
    }

    public static void main(String[] args) {
        getAnswers();
    }
}
