import java.util.List;

public class Sum {
    int sumList(List<Integer> list) {
        int sum = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            for (Integer number : list) {
                sum += number;
            }
        }
        return sum;
    }
}
