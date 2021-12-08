import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {
    public static int findOdd(int[] numbers) {
        int odd = 0;
        Map<Integer, Integer> occurrence = new HashMap<>();

        for (int number : numbers) {
            if (!occurrence.containsKey(number)) {
                occurrence.put(number, 1);
            } else {
                int value = occurrence.get(number) + 1;
                occurrence.put(number, value);
            }
        }

        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd = entry.getKey();
                break;
            }
        }

        return odd;
    }

    public static void main(String[] args) {
        int[] numbers1 = {7};
        int[] numbers2 = {0};
        int[] numbers3 = {1, 1, 2};
        int[] numbers4 = {0, 1, 0, 1, 0};
        int[] numbers5 = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};

        System.out.println(findOdd(numbers1));
        System.out.println(findOdd(numbers2));
        System.out.println(findOdd(numbers3));
        System.out.println(findOdd(numbers4));
        System.out.println(findOdd(numbers5));
    }
}
