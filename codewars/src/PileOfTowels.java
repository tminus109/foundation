import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PileOfTowels {
    public static List<String> sortPile(List<String> cleanTowels, List<Integer> numOfTowelsUsedEachWeek) {
        for (Integer numOfTowels : numOfTowelsUsedEachWeek) {
            List<String> usedTowels = new ArrayList<>();
            int index = cleanTowels.size() - 1;

            for (int i = 0; i < numOfTowels; i++) {
                usedTowels.add(cleanTowels.remove(index));
                index--;
            }

            usedTowels.sort(Collections.reverseOrder());
            cleanTowels.addAll(usedTowels);
        }

        return cleanTowels;
    }

    public static void main(String[] args) {
        List<String> cleanTowels = new ArrayList<>(Arrays.asList("blue", "red", "blue", "red", "blue"));
        List<String> cleanTowels2 = new ArrayList<>(Arrays.asList("blue", "red", "blue", "red", "blue"));
        List<Integer> numOfTowelsUsedEachWeek = new ArrayList<>(Arrays.asList(4, 2, 5, 3));
        List<Integer> numOfTowelsUsedEachWeek2 = new ArrayList<>(Arrays.asList(3, 2));

        System.out.println(sortPile(cleanTowels, numOfTowelsUsedEachWeek));
        System.out.println(sortPile(cleanTowels2, numOfTowelsUsedEachWeek2));
    }
}
