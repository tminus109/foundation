import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));

        if (shoppingList.contains("milk")) {
            System.out.println("There's milk on the list.");
        } else {
            System.out.println("There's no milk on the list.");
        }

        if (shoppingList.contains("banana")) {
            System.out.println("There's banana on the list.");
        } else {
            System.out.println("There's no banana on the list.");
        }
    }
}
