import java.util.HashMap;
import java.util.Map;

public class FindTheUniqueNumber {
    public static double findUniqueNumber(double[] arr) {
        double uniqueNumber = -1.;
        Map<Double, Integer> numberCount = new HashMap<>();

        for (double key : arr) {
            if (!numberCount.containsKey(key)) {
                numberCount.put(key, 1);
            } else {
                int count = numberCount.get(key) + 1;
                numberCount.put(key, count);
            }
        }

        for (Map.Entry<Double, Integer> entry : numberCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueNumber = entry.getKey();
                break;
            }
        }

        return uniqueNumber;
    }

    public static void main(String[] args) {
        double[] arr0 = {1, 1, 1, 2, 1, 1};
        double[] arr1 = {0, 0, 0.55, 0, 0};

        System.out.println(findUniqueNumber(arr0));
        System.out.println(findUniqueNumber(arr1));
    }
}
