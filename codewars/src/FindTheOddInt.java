import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {
    public static Object findOddInt(int[] numbers) {
        Map<Integer, Integer> mappedNumbers = new HashMap<>();

        for (int number : numbers) {
            if (!mappedNumbers.containsKey(number)) {
                mappedNumbers.put(number, 1);
            } else {
                int value = mappedNumbers.get(number) + 1;
                mappedNumbers.put(number, value);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mappedNumbers.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return "It's all even.";
    }

    public static void main(String[] args) {
        int[] numbers1 = {7};
        int[] numbers2 = {0};
        int[] numbers3 = {1, 1, 2};
        int[] numbers4 = {0, 1, 0, 1, 0};
        int[] numbers5 = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};
        int[] numbers6 = {7, 7};


        System.out.println(findOddInt(numbers1));
        System.out.println(findOddInt(numbers2));
        System.out.println(findOddInt(numbers3));
        System.out.println(findOddInt(numbers4));
        System.out.println(findOddInt(numbers5));
        System.out.println(findOddInt(numbers6));
    }
}
