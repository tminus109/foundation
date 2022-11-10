import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static long[] getPascalsTriangle(int level) {
        List<Long> numbers = new ArrayList<>();
        int rowLength = 1;

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (j == 0 || j == (rowLength - 1)) {
                    numbers.add(1L);
                } else {
                    numbers.add(
                            numbers.get(numbers.size() - rowLength) +
                                    numbers.get(numbers.size() - (rowLength - 1)));
                }
            }
            rowLength++;
        }

        long[] triangle = new long[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            triangle[i] = numbers.get(i);
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPascalsTriangle(1)));
        System.out.println(Arrays.toString(getPascalsTriangle(4)));
        System.out.println(Arrays.toString(getPascalsTriangle(6)));
        System.out.println(Arrays.toString(getPascalsTriangle(0)));
    }
}
