import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonalFinance {
    public static void sumExpenses(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
//        int sum = list.stream().mapToInt(Integer::valueOf).sum();
//        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void greatestExpense(ArrayList<Integer> list) {
//        int max = Collections.max(list);
        int max = list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
//        int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(max);
    }

    public static void cheapestSpending(ArrayList<Integer> list) {
        int cheapestSpending = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (cheapestSpending > list.get(i)) {
                cheapestSpending = list.get(i);
            }
        }
//        int cheapestSpending = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
//        int cheapestSpending = Collections.min(list);
        System.out.println(cheapestSpending);
    }

    public static void averageSpending(ArrayList<Integer> list) {
        int totalSpending = 0;
        for (Integer integer : list) {
            totalSpending += integer;
        }
        int averageSpending = totalSpending / list.size();
//        int averageSpending = (int) list.stream().mapToInt(Integer::valueOf).average().getAsDouble();
        System.out.println(averageSpending);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
        sumExpenses(list);
        greatestExpense(list);
        cheapestSpending(list);
        averageSpending(list);
    }
}
