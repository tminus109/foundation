import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {
    public static List<Integer> findEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> squarePositiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<Integer> findNumbersSquaredGreaterThan20(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n * n > 20)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(findEvenNumbers(numbers));

        System.out.println(squarePositiveNumbers(numbers));

        List<Integer> numbers2 = Arrays.asList(3, 9, 2, 8, 6, 5);
        System.out.println(findNumbersSquaredGreaterThan20(numbers2));
    }
}
