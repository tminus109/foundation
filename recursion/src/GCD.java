public class GCD {
    static int findGreatestCommonDivisor(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        } else if (n1 == n2) {
            return n1;
        } else if (n1 > n2) {
            return findGreatestCommonDivisor(n1 - n2, n2);
        } else {
            return findGreatestCommonDivisor(n2 - n1, n1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findGreatestCommonDivisor(13, 6));
        System.out.println(-6 / 2);
    }
}
