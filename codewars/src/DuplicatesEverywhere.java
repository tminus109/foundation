import java.util.*;

public class DuplicatesEverywhere {
    public static Map<String, List<Character>>
    removeDuplicates(Map<String, List<Character>> table) {
        Map<String, List<Character>> tableWithoutDuplicates = new HashMap<>();

        for (Map.Entry<String, List<Character>> entry : table.entrySet()) {
            List<Character> value = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (!value.contains(entry.getValue().get(i))) {
                    value.add(entry.getValue().get(i));
                }
            }
            tableWithoutDuplicates.put(entry.getKey(), value);
        }

        List<Integer> keys = new ArrayList<>();

        for (String key : tableWithoutDuplicates.keySet()) {
            keys.add(Integer.parseInt(key));
        }

        Collections.sort(keys);

        int length = keys.size() - 1;

        for (int i = length; i >= 0; i--) {
            String key = String.valueOf(keys.get(i));
            List<Character> chars = tableWithoutDuplicates.get(key);
            for (int j = (i - 1); j >= 0; j--) {
                String nextKey = String.valueOf(keys.get(j));
                for (Character c : chars) {
                    tableWithoutDuplicates.get(nextKey).remove(c);
                }
            }
        }

        return tableWithoutDuplicates;
    }

    public static void main(String[] args) {
        Map<String, List<Character>> table = new HashMap<>();
        List<Character> v11 = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
        List<Character> v12 = new ArrayList<>(Arrays.asList('A', 'B', 'D', 'A'));
        table.put("1", v11);
        table.put("2", v12);

        Map<String, List<Character>> table2 = new HashMap<>();
        List<Character> v21 = new ArrayList<>(Arrays.asList('C', 'F', 'G'));
        List<Character> v22 = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
        List<Character> v23 = new ArrayList<>(Arrays.asList('A', 'B', 'D'));
        table2.put("1", v21);
        table2.put("2", v22);
        table2.put("3", v23);

        Map<String, List<Character>> table3 = new HashMap<>();
        List<Character> v31 = new ArrayList<>(List.of('A'));
        List<Character> v32 = new ArrayList<>(List.of('A'));
        List<Character> v33 = new ArrayList<>(List.of('A'));
        table3.put("1", v31);
        table3.put("2", v32);
        table3.put("3", v33);

        Map<String, List<Character>> table4 = new HashMap<>();
        List<Character> v41 = new ArrayList<>(Arrays.asList('A', 'A', 'B', 'D'));
        List<Character> v42 = new ArrayList<>(Arrays.asList('L', 'G', 'B', 'C'));
        List<Character> v43 = new ArrayList<>(Arrays.asList('L', 'A', 'X', 'G', 'H', 'X'));
        List<Character> v44 = new ArrayList<>(Arrays.asList('P', 'R', 'S', 'D'));
        table4.put("432", v41);
        table4.put("53", v42);
        table4.put("236", v43);
        table4.put("11", v44);

        System.out.println(removeDuplicates(table));
        System.out.println(removeDuplicates(table2));
        System.out.println(removeDuplicates(table3));
        System.out.println(removeDuplicates(table4));
    }
}
