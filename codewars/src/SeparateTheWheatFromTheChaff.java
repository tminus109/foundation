import java.util.Arrays;

public class SeparateTheWheatFromTheChaff {
    public static int[] separateWheatFromChaff(int[] chaff) {
        int[] wheat = new int[chaff.length];
        int head = 0;
        int tail = chaff.length - 1;

        while (head <= tail) {
            if (chaff[head] < 0) {
                wheat[head] = chaff[head];
                head++;
            } else if (chaff[tail] > 0) {
                wheat[tail] = chaff[tail];
                tail--;
            } else {
                wheat[tail] = chaff[head];
                wheat[head] = chaff[tail];
                head++;
                tail--;
            }
        }

        return wheat;
    }

    public static void main(String[] args) {
        int[] wheatAndChaff0 = {7, -8, 1, -2};
        int[] wheatAndChaff1 = {-31, -5, 11, -42, -22, -46, -4, -28};
        int[] wheatAndChaff2 = {-25, -48, -29, -25, 1, 49, -32, -19, -46, 1};

        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff0)));
        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff1)));
        System.out.println(Arrays.toString(separateWheatFromChaff(wheatAndChaff2)));
    }
}
