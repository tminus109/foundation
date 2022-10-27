public class SubarrayDivision {
    public static int findSegments(int[] chocolate, int d, int m) {
        int count = 0;
        int l = chocolate.length - m + 1;

        for (int i = 0; i < l; i++) {
            int segment = 0;
            for (int j = i; j < (i + m); j++) {
                segment += chocolate[j];
            }
            if (segment == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findSegments(new int[]{2, 2, 1, 3, 2}, 4, 2));
        System.out.println(findSegments(new int[]{1, 2, 1, 3, 2}, 3, 2));
        System.out.println(findSegments(new int[]{1, 1, 1, 1, 1, 1}, 3, 2));
        System.out.println(findSegments(new int[]{4}, 4, 1));
        System.out.println(findSegments(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 24, 12));
        System.out.println(findSegments(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 2, 1));
    }
}
