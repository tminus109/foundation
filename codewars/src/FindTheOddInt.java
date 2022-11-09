import java.util.HashMap;
import java.util.Map;

//import java.util.Arrays;

public class FindTheOddInt {
    public static int findOddInt(int[] a) {
        int odd = 0;
        Map<Integer, Integer> mappedNumbers = new HashMap<>();

        for (int number : a) {
            if (!mappedNumbers.containsKey(number)) {
                mappedNumbers.put(number, 1);
            } else {
                int value = mappedNumbers.get(number) + 1;
                mappedNumbers.put(number, value);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mappedNumbers.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd = entry.getKey();
                break;
            }
        }

        return odd;

//        return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
    }

    public static void main(String[] args) {
        int[] numbers1 = {7};
        int[] numbers2 = {0};
        int[] numbers3 = {1, 1, 2};
        int[] numbers4 = {0, 1, 0, 1, 0};
        int[] numbers5 = {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1};
        int[] numbers6 = {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};
        int[] numbers7 = {1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5};
        int[] numbers8 = {20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5};
        int[] numbers9 = {1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1};
        int[] numbers10 = {5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10};

        System.out.println(findOddInt(numbers1));
        System.out.println(findOddInt(numbers2));
        System.out.println(findOddInt(numbers3));
        System.out.println(findOddInt(numbers4));
        System.out.println(findOddInt(numbers5));
        System.out.println(findOddInt(numbers6));
        System.out.println(findOddInt(numbers7));
        System.out.println(findOddInt(numbers8));
        System.out.println(findOddInt(numbers9));
        System.out.println(findOddInt(numbers10));
    }
}
