public class MultiplesOf3And5 {
    public static int findMultiples(int input) {
        int sum = 0;

        for (int i = 1; i < input; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i;
            } else if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int input1 = 10;
        int input2 = -10;

        System.out.println(findMultiples(input1));
        System.out.println(findMultiples(input2));
    }
}
