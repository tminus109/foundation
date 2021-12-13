import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueInOrder {
    public static List<Object> uniqueInOrder(List<Object> input) {
        List<Object> output = new ArrayList<>();
        List<Object> arr;

        if (input.size() == 1 && input.get(0) instanceof String) {
            arr = Arrays.asList(((String) input.get(0)).split(""));
        } else {
            arr = input;
        }

        output.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            if (!arr.get(i).equals(arr.get(i - 1))) {
                output.add(arr.get(i));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        List<Object> uniqueInOrder1 = new ArrayList<>(List.of("AAAABBBCCDAABBB"));
        List<Object> uniqueInOrder2 = new ArrayList<>(List.of("ABBCcAD"));
        List<Object> uniqueInOrder3 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3));

        System.out.println(uniqueInOrder(uniqueInOrder1));
        System.out.println(uniqueInOrder(uniqueInOrder2));
        System.out.println(uniqueInOrder(uniqueInOrder3));
    }
}
