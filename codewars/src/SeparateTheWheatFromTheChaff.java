import java.util.Arrays;

public class SeparateTheWheatFromTheChaff {
    public static int[] separateWheatFromChaff(int[] wheatAndChaff) {
        int[] wheatFromChaff = new int[wheatAndChaff.length];
        int head = 0;
        int tail = wheatAndChaff.length - 1;

        while (head <= tail) {
            if (wheatAndChaff[head] < 0) {
                wheatFromChaff[head] = wheatAndChaff[head];
                head++;
            } else if (wheatAndChaff[tail] > 0) {
                wheatFromChaff[tail] = wheatAndChaff[tail];
                tail--;
            } else {
                wheatFromChaff[tail] = wheatAndChaff[head];
                wheatFromChaff[head] = wheatAndChaff[tail];
                head++;
                tail--;
            }
        }

        return wheatFromChaff;
    }

    public static void main(String[] args) {
        int[] wheatAndChaff = {7, -8, 1, -2};
        int[] wheatAndChaff1 = {-31, -5, 11, -42, -22, -46, -4, -28};
        int[] wheatAndChaff2 = {-25, -48, -29, -25, 1, 49, -32, -19, -46, 1};

        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff)));
        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff1)));
        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff2)));
    }
}
