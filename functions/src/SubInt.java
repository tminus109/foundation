import java.util.ArrayList;

public class SubInt {
    public static ArrayList<Integer> findMatchingIndexes(int number, int[] numbers) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String s = "";
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 9) {
                s = String.valueOf(numbers[i]);
                for (int j = 0; j < s.length(); j++) {
                    if (Character.digit(s.charAt(j), 10) == number) {
                        indexes.add(i);
                        break;
                    }
                }
            } else if (number == numbers[i]) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        System.out.println(findMatchingIndexes(1, new int[]{1, 11, 34, 52, 61}));
        System.out.println(findMatchingIndexes(9, new int[]{1, 11, 34, 52, 61}));
        System.out.println(findMatchingIndexes(9, new int[]{1, 11, 34, 52, 61, 999}));
    }
}
