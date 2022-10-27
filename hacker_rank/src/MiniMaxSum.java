public class MiniMaxSum {
    public static void findMinAndMaxSum(int[] arr) {
        long sum = 0;
        long smallestNum = arr[0];
        long biggestNum = arr[0];

        for (long n : arr) {
            if (n < smallestNum) {
                smallestNum = n;
            } else if (n > biggestNum) {
                biggestNum = n;
            }
            sum += n;
        }

        System.out.println("min. sum = " + (sum - biggestNum) + " | max. sum = " + (sum - smallestNum));
    }

    public static void main(String[] args) {
        findMinAndMaxSum(new int[]{1, 2, 3, 4, 5});
        findMinAndMaxSum(new int[]{1, 3, 5, 7, 9});
    }
}
