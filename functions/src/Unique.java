import java.util.ArrayList;

public class Unique {
    public static ArrayList<Integer> findUniqueInts(int[] input) {
        ArrayList<Integer> uniqueInts = new ArrayList<>();
        for (int j : input) {
            if (!uniqueInts.contains(j)) {
                uniqueInts.add(j);
            }
        }
        return uniqueInts;
    }

    public static void main(String[] args) {
        System.out.println(findUniqueInts(new int[]{1, 11, 34, 11, 52, 61, 1, 34}));
        System.out.println(findUniqueInts(new int[]{11, 11, 11, 11, 11, 11, 1, 11}));
    }
}
