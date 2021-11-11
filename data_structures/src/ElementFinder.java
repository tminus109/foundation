import java.util.ArrayList;
import java.util.Arrays;

public class ElementFinder {
    public static String containsSeven(ArrayList<Integer> input) {
        if (input.contains(7)) {
            return "Hoorray";
        } else {
            return "Noooooo";
        }
    }

    public static String containsSeven2(ArrayList<Integer> input) {
        for (Integer integer : input) {
            if (integer == 7) {
                return "Hoorray";
            }
        }
        return "Noooooo";
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> input2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(containsSeven(input));
        System.out.println(containsSeven(input2));
        System.out.println(containsSeven2(input));
        System.out.println(containsSeven2(input2));
    }
}
