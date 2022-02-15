import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {
//    Exercise 1

    public static List<Integer> findEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    //    Exercise 2

    public static List<Integer> squarePositiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }
//    Exercise 3

    public static List<Integer> findNumbersSquaredGreaterThan20(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n * n > 20)
                .collect(Collectors.toList());
    }
//    Exercise 4

    public static double calculateAverageOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.averagingDouble(n -> n));
    }

    public static void main(String[] args) {
        //    Exercise 1
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(findEvenNumbers(numbers));

        //    Exercise 2
        System.out.println(squarePositiveNumbers(numbers));

        //    Exercise 3
        List<Integer> numbers2 = Arrays.asList(3, 9, 2, 8, 6, 5);
        System.out.println(findNumbersSquaredGreaterThan20(numbers2));

        //    Exercise 4
        List<Integer> numbers3 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        System.out.println(calculateAverageOfOddNumbers(numbers3));
    }
}
