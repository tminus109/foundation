public class Sum {
    public static int sumFromZeroToN(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n + sumFromZeroToN(n - 1));
        }
    }

    public static int sumFromZeroToN2(int n) {
        int sum = 0;
        int number = n;
        for (int i = 0; i < n; i++) {
            sum += number;
            number--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumFromZeroToN(5));
        System.out.println(sumFromZeroToN2(5));
    }
}
