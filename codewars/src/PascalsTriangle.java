import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<Integer> getPascalsTriangle(int depth, int firstNum) {
        if (depth < 1) {
            return new ArrayList<>();
        }

        List<Integer> triangle = new ArrayList<>();
        int rowLength = 1;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (j == 0 || j == (rowLength - 1)) {
                    triangle.add(firstNum);
                } else {
                    triangle.add(
                            triangle.get(triangle.size() - rowLength) +
                                    triangle.get(triangle.size() - (rowLength - 1)));
                }
            }
            rowLength++;
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(getPascalsTriangle(1, 1));
        System.out.println(getPascalsTriangle(4, 1));
        System.out.println(getPascalsTriangle(6, 2));
        System.out.println(getPascalsTriangle(0, 1));
    }
}
