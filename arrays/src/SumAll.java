import java.util.Arrays;

public class SumAll {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 6, 7};

//      method #1:
        System.out.println(Arrays.stream(numbers).sum());

//      method #2:
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }
}
