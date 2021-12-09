import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PileOfTowels {
    public static List<String> sortThePile(List<String> towels, List<Integer> t) {

        for (Integer integer : t) {
            List<String> usedTowels = new ArrayList<>();
            int length = towels.size() - integer;
            for (int j = towels.size() - 1; j >= length; j--) {
                usedTowels.add(towels.get(j));
                towels.remove(j);
            }
            usedTowels.sort(Collections.reverseOrder());
            towels.addAll(usedTowels);
        }

        return towels;
    }

    public static void main(String[] args) {
        List<String> towels = new ArrayList<>(Arrays.asList("blue", "red", "blue", "red", "blue"));
        List<Integer> t = new ArrayList<>(Arrays.asList(4, 2, 5, 3));

        System.out.println(sortThePile(towels, t));
    }
}
