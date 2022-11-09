public class FindTheUniqueNumber {
    public static double findUniq(double[] numbers) {
        for (double n : numbers) {
            int count = 0;
            for (double number : numbers) {
                if (n == number) {
                    count++;
                }
            }
            if (count == 1) {
                return n;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        double[] arr = {1, 1, 1, 2, 1, 1};
        double[] arr1 = {0, 0, 0.55, 0, 0};
        double[] arr2 = {1, 1, 1, 1, 1, 3};
        double[] arr3 = {1, 8, 4, 4, 6, 1, 8};
        double[] arr4 = {1, 4, 4, 5, 5, 3, 3, 2, 2};
        double[] arr5 = {2, 2, 5, 5, 4, 3, 3, 1, 1};
        double[] arr6 = {3, 5, 5, 4, 4, 3, 2, 2, 9};

        System.out.println(findUniq(arr));
        System.out.println(findUniq(arr1));
        System.out.println(findUniq(arr2));
        System.out.println(findUniq(arr3));
        System.out.println(findUniq(arr4));
        System.out.println(findUniq(arr5));
        System.out.println(findUniq(arr6));
    }
}
