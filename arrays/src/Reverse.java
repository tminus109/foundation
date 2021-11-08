import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 8};

//      method #1:
        int[] reversedNumbers = new int[numbers.length];
        int j = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            reversedNumbers[j] = numbers[i];
            j++;
        }
        numbers = reversedNumbers;
        System.out.println(Arrays.toString(numbers));

//      method #2:
        for (int i = 0; i < numbers.length / 2; i++) {
            int k = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = k;
        }
        System.out.println(Arrays.toString(numbers));

//      method #3:
        Integer[] numbers2 = {4, 5, 6, 7, 8};
        Collections.reverse(Arrays.asList(numbers2));
        System.out.println(Arrays.asList(numbers2));
    }
}
