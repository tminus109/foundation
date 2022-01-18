import java.util.ArrayList;
import java.util.List;

public class FinalExam {
    public static List<Integer> secondLargestPerimeter(int[][] triangles) {
        List<Integer> secondLargestPerimeters = new ArrayList<>();

        if (triangles.length < 2) {
            secondLargestPerimeters.add(-1);
            return secondLargestPerimeters;
        }

        int[] perimeters = new int[triangles.length];

        for (int i = 0; i < triangles.length; i++) {
            int perimeter = 0;
            for (int j = 0; j < 3; j++) {
                perimeter += triangles[i][j];
            }
            perimeters[i] = perimeter;
        }

        int largestTriangle = 0;

        for (int perimeter : perimeters) {
            if (perimeter > largestTriangle) {
                largestTriangle = perimeter;
            }
        }

        int secondLargestTriangle = 0;

        for (int perimeter : perimeters) {
            if (perimeter > secondLargestTriangle && perimeter < largestTriangle) {
                secondLargestTriangle = perimeter;
            }
        }

        for (int i = 0; i < perimeters.length; i++) {
            if (perimeters[i] == secondLargestTriangle) {
                secondLargestPerimeters.add(i);
            }
        }

        return secondLargestPerimeters;
    }

    public static void main(String[] args) {
        int[][] triangles0 = {{7, 8, 9}, {4, 5, 6}, {4, 5, 6}, {7, 8, 9}};
        int[][] triangles1 = {{2, 3, 4}, {7, 8, 9}, {4, 5, 6}, {10, 11, 12}};
        int[][] triangles2 = {{7, 8, 9}, {10, 11, 12}, {4, 5, 6}, {2, 3, 4}};
        int[][] triangles3 = {{2, 3, 4}, {10, 11, 12}, {4, 5, 6}, {7, 8, 9}};
        int[][] triangles4 = {{2, 3, 4}, {4, 5, 6,}};
        int[][] triangles5 = {};

        System.out.println(secondLargestPerimeter(triangles0));
        System.out.println(secondLargestPerimeter(triangles1));
        System.out.println(secondLargestPerimeter(triangles2));
        System.out.println(secondLargestPerimeter(triangles3));
        System.out.println(secondLargestPerimeter(triangles4));
        System.out.println(secondLargestPerimeter(triangles5));
    }
}
