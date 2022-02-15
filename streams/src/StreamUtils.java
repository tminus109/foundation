import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

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

    //    Exercise 8
    public static String concatChars(List<Character> chars) {
        return chars.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    //    Exercise 9
    public static Map<Character, Integer> countFrequencyOfChars(String string) {
        return string.chars()
                .boxed()
                .collect(toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum));
    }

    //    Exercise 10
    public static List<Fox> findGreenFoxes(List<Fox> foxes) {
        return foxes.stream()
                .filter(fox -> fox.color.equals("green"))
                .collect(Collectors.toList());
    }

    public static List<Fox> findGreenFoxesAgedLessThan5(List<Fox> foxes) {
        return foxes.stream()
                .filter(fox -> fox.color.equals("green") && fox.age < 5)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> countFrequencyOfFoxesByColor(List<Fox> foxes) {
        return foxes.stream()
                .collect(toMap(
                        Fox::getColor,
                        v -> 1,
                        Integer::sum));
    }

    //    Exercise 11
    public static Map<String, Integer> getWordFrequency(String file) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            wordFrequency = Files.lines(Paths.get(file))
                    .map(l -> l.split("[^a-zA-Z]+"))
                    .flatMap(Arrays::stream)
                    .filter(s -> !s.isEmpty())
                    .collect(toMap(
                            String::toLowerCase,
                            v -> 1,
                            Integer::sum));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    public static List<Map.Entry<String, Integer>> getMostCommonWordsDesc(String file) {
        return getWordFrequency(file)
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    //    Main
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

        //    Exercise 8
        List<Character> characters =
                Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
        System.out.println(concatChars(characters));

        //    Exercise 9
        String string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt.";
        System.out.println(countFrequencyOfChars(string));

        //    Exercise 10
        List<Fox> foxes = new ArrayList<>(Arrays.asList(
                new Fox("f1", "red", 1),
                new Fox("f2", "blue", 2),
                new Fox("f3", "yellow", 3),
                new Fox("f4", "green", 4),
                new Fox("f5", "black", 5),
                new Fox("f6", "black", 6),
                new Fox("f7", "green", 2),
                new Fox("f8", "green", 10)));
        System.out.println(findGreenFoxes(foxes).toString());
        System.out.println(findGreenFoxesAgedLessThan5(foxes).toString());
        System.out.println(countFrequencyOfFoxesByColor(foxes));

        //    Exercise 11
        String file = "assets/thor.txt";
        System.out.println(getWordFrequency(file));
        System.out.println(getMostCommonWordsDesc(file));
    }
}
