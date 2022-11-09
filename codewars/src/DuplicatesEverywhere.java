import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesEverywhere {
    public static Map<Integer, List<String>>
    removeDuplicateIds(Map<Integer, List<String>> obj) {
        Map<Integer, List<String>> output = new HashMap<>();
        HashSet<String> uniqueChars = new HashSet<>();

        List<Integer> keys = obj.keySet()
                .stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        for (Integer key : keys) {
            List<String> value = obj.get(key);
            List<String> newValue = new ArrayList<>();
            for (String s : value) {
                if (!uniqueChars.contains(s)) {
                    newValue.add(s);
                }
                uniqueChars.add(s);
            }
            output.put(key, newValue);
        }

        return output;
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> table = new HashMap<>();
        List<String> v11 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> v12 = new ArrayList<>(Arrays.asList("A", "B", "D", "A"));
        table.put(1, v11);
        table.put(2, v12);

        Map<Integer, List<String>> table2 = new HashMap<>();
        List<String> v21 = new ArrayList<>(Arrays.asList("C", "F", "G"));
        List<String> v22 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> v23 = new ArrayList<>(Arrays.asList("A", "B", "D"));
        table2.put(1, v21);
        table2.put(2, v22);
        table2.put(3, v23);

        Map<Integer, List<String>> table3 = new HashMap<>();
        List<String> v31 = new ArrayList<>(List.of("A"));
        List<String> v32 = new ArrayList<>(List.of("A"));
        List<String> v33 = new ArrayList<>(List.of("A"));
        table3.put(1, v31);
        table3.put(2, v32);
        table3.put(3, v33);

        Map<Integer, List<String>> table4 = new HashMap<>();
        List<String> v41 = new ArrayList<>(Arrays.asList("A", "A", "B", "D"));
        List<String> v42 = new ArrayList<>(Arrays.asList("L", "G", "B", "C"));
        List<String> v43 = new ArrayList<>(Arrays.asList("L", "A", "X", "G", "H", "X"));
        List<String> v44 = new ArrayList<>(Arrays.asList("P", "R", "S", "D"));
        table4.put(432, v41);
        table4.put(53, v42);
        table4.put(236, v43);
        table4.put(11, v44);

        System.out.println(removeDuplicateIds(table));
        System.out.println(removeDuplicateIds(table2));
        System.out.println(removeDuplicateIds(table3));
        System.out.println(removeDuplicateIds(table4));
    }
}
