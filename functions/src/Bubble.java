import java.util.Arrays;

public class Bubble {
    public static int[] arraySorter(int[] input) {
        return Arrays.stream(input).sorted().toArray();
    }

    public static int[] arrayReverser(int[] input) {
        int[] reversedInput = new int[input.length];
        int j = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            reversedInput[j] = input[i];
            j++;
        }
        return reversedInput;
    }

    public static int[] arraySorter2(int[] input, boolean sortDirection) {
        if (sortDirection) {
            int[] sortedInput = arraySorter(input);
            return arrayReverser(sortedInput);
        } else {
            return arraySorter(input);
        }
    }

    //  Bubble-sort
    public static int[] arraySorter3(int[] input) {
        int x = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j + 1] < input[j]) {
                    x = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = x;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input1 = {3, 5, 4, 2, 1};
        int[] input2 = {20, 40, 10, 30, 50};
        int[] output1 = arraySorter(input1);
        int[] output2 = arraySorter2(input1, true);
        int[] output3 = arraySorter2(input1, false);
        int[] output4 = arraySorter3(input2);
        int[] output5 = arraySorter3(input1);

        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
        System.out.println(Arrays.toString(output3));
        System.out.println(Arrays.toString(output4));
        System.out.println(Arrays.toString(output5));
    }
}
