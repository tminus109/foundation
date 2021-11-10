public class Factorio {
    public static int calculateFactorialUsingALoop(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int factorialUsingRecursion(int n) {
        if (n == 0) {
            return 1;
        } else return (n * factorialUsingRecursion(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorialUsingALoop(5));
        System.out.println(factorialUsingRecursion(5));
    }
}
