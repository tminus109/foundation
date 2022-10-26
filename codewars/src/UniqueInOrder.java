import java.util.ArrayList;
import java.util.List;

public class UniqueInOrder {
    public static List<Object> getUniqueInOrder(Object input) {
        List<Object> uniqueInOrder = new ArrayList<>();
        Object[] arr = {};

        if (input instanceof String) {
            arr = (((String) input).split(""));
        } else if (input instanceof Object[]) {
            arr = (Object[]) input;
        }

        uniqueInOrder.add(arr[0]);

        int l = arr.length - 1;

        for (int i = 0; i < l; i++) {
            if (!arr[i + 1].equals(arr[i])) {
                uniqueInOrder.add(arr[i + 1]);
            }
        }

        return uniqueInOrder;
    }

    public static void main(String[] args) {
        String uniqueInOrder = "AAAABBBCCDAABBB";
        String uniqueInOrder2 = "ABBCcAD";
        Integer[] uniqueInOrder3 = {1, 2, 2, 3, 3};

        System.out.println(getUniqueInOrder(uniqueInOrder));
        System.out.println(getUniqueInOrder(uniqueInOrder2));
        System.out.println(getUniqueInOrder(uniqueInOrder3));
    }
}
