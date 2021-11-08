import java.util.Arrays;
import java.util.Collections;

public class SwapElements {
    public static void main(String[] args) {
        String[] orders = {"first", "second", "third"};

//      method #1:
        String[] reversedOrders = new String[orders.length];
        int j = 0;
        for (int i = orders.length - 1; i >= 0; i--) {
            reversedOrders[j] = orders[i];
            j++;
        }
        orders = reversedOrders;
        System.out.println(Arrays.toString(orders));

//      method #2:
        for (int i = 0; i < orders.length / 2; i++) {
            String k = orders[i];
            orders[i] = orders[orders.length - 1 - i];
            orders[orders.length - 1 - i] = k;
        }
        System.out.println(Arrays.toString(orders));

//      method #3:
        Collections.reverse(Arrays.asList(orders));
        System.out.println(Arrays.asList(orders));
    }
}
