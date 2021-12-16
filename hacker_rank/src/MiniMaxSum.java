public class MiniMaxSum {
    public static void miniMaxSum(int[] input) {
        long minimumSum = Long.MAX_VALUE;
        long maximumSum = Long.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < input.length; i++) {
            long temp = 0;
            for (int j = 0; j < input.length; j++) {
                if (j != index) {
                    temp += input[j];
                }
            }
            if (temp < minimumSum) {
                minimumSum = temp;
            }
            if (temp > maximumSum) {
                maximumSum = temp;
            }
            index++;
        }

        System.out.println(minimumSum + " " + maximumSum);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 3, 5, 7, 9};

        miniMaxSum(arr);
        miniMaxSum(arr2);
    }
}
