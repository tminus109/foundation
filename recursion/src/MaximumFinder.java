import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumFinder {
    static int findLargestElement(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        } else if (numbers.size() == 1) {
            return numbers.get(0);
        } else {
            int largestElement = numbers.get(0);
            return Math.max(largestElement, findLargestElement(numbers.subList(1, numbers.size())));
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 222, 1, -1, 9, 2345));
        System.out.println(findLargestElement(numbers));
    }
}
