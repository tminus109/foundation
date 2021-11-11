import java.util.Arrays;
import java.util.List;

public class IsInList {
    public static boolean checkNumbers(List<Integer> input) {
        int[] elements = {4, 8, 12, 16};
        for (int element : elements) {
            if (!input.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16);
        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 10, 12, 14, 16);
        System.out.println(checkNumbers(numbers));
        System.out.println(checkNumbers(numbers2));
    }
}
