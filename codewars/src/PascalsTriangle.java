import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<Integer> pascalsTriangle(int depth, int init) {
        List<Integer> triangle = new ArrayList<>();
        int length = 1;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < length; j++) {
                if (j == 0 || j == length - 1) {
                    triangle.add(init);
                } else {
                    triangle.add(triangle.get(triangle.size() - length) +
                            triangle.get(triangle.size() - (length - 1)));
                }
            }
            length++;
        }

        return triangle;
    }

    public static void main(String[] args) {
        int init = 1;
        int depth0 = 1;
        int depth1 = 2;
        int depth2 = 4;
        int depth4 = 7;

        System.out.println(pascalsTriangle(depth0, init));
        System.out.println(pascalsTriangle(depth1, init));
        System.out.println(pascalsTriangle(depth2, init));
        System.out.println(pascalsTriangle(depth4, init));
    }
}
