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

    //    Exercise 5
    public static int calculateSumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n)
                .sum();
    }

    //    Exercise 6
    public static List<Character> findUppercaseChars(String string) {
        return string.chars()
                .filter(Character::isUpperCase)
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }

    //    Exercise 7
    public static List<String> findStringsStartingWithSpecifiedChar(List<String> cities, char c) {
        return cities.stream()
                .filter(s -> s.charAt(0) == c)
                .collect(Collectors.toList());
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

        //    Exercise 5
        List<Integer> numbers4 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        System.out.println(calculateSumOfOddNumbers(numbers4));

        //    Exercise 6
        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
        System.out.println(findUppercaseChars(s));

        //    Exercise 7
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH",
                "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        System.out.println(findStringsStartingWithSpecifiedChar(cities, 'R'));
        System.out.println(findStringsStartingWithSpecifiedChar(cities, 'N'));
    }
}
