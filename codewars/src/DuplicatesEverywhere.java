import java.util.*;

public class DuplicatesEverywhere {
    public static Map<String, List<Character>>
    findDuplicates(Map<String, List<Character>> duplicates) {
        Map<String, List<Character>> noDuplicates = new HashMap<>();

        for (Map.Entry<String, List<Character>> entry : duplicates.entrySet()) {
            List<Character> value = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (!value.contains(entry.getValue().get(i))) {
                    value.add(entry.getValue().get(i));
                }
            }
            noDuplicates.put(entry.getKey(), value);
        }

        List<Integer> keys = new ArrayList<>();

        for (String key : noDuplicates.keySet()) {
            keys.add(Integer.parseInt(key));
        }

        Collections.sort(keys);

        int length = keys.size() - 1;

        for (int i = length; i >= 0; i--) {
            String key = String.valueOf(keys.get(i));
            List<Character> chars = noDuplicates.get(key);
            for (int j = (i - 1); j >= 0; j--) {
                String nextKey = String.valueOf(keys.get(j));
                for (Character c : chars) {
                    noDuplicates.get(nextKey).remove(c);
                }
            }
        }

        return noDuplicates;
    }

    public static void main(String[] args) {
        Map<String, List<Character>> duplicates0 = new HashMap<>();
        List<Character> d01 = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
        List<Character> d02 = new ArrayList<>(Arrays.asList('A', 'B', 'D', 'A'));
        duplicates0.put("1", d01);
        duplicates0.put("2", d02);

        Map<String, List<Character>> duplicates1 = new HashMap<>();
        List<Character> d11 = new ArrayList<>(Arrays.asList('C', 'F', 'G'));
        List<Character> d12 = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
        List<Character> d13 = new ArrayList<>(Arrays.asList('A', 'B', 'D'));
        duplicates1.put("1", d11);
        duplicates1.put("2", d12);
        duplicates1.put("3", d13);

        Map<String, List<Character>> duplicates2 = new HashMap<>();
        List<Character> d21 = new ArrayList<>(List.of('A'));
        List<Character> d22 = new ArrayList<>(List.of('A'));
        List<Character> d23 = new ArrayList<>(List.of('A'));
        duplicates2.put("1", d21);
        duplicates2.put("2", d22);
        duplicates2.put("3", d23);

        Map<String, List<Character>> duplicates3 = new HashMap<>();
        List<Character> d31 = new ArrayList<>(Arrays.asList('A', 'A', 'B', 'D'));
        List<Character> d32 = new ArrayList<>(Arrays.asList('L', 'G', 'B', 'C'));
        List<Character> d33 = new ArrayList<>(Arrays.asList('L', 'A', 'X', 'G', 'H', 'X'));
        List<Character> d34 = new ArrayList<>(Arrays.asList('P', 'R', 'S', 'D'));
        duplicates3.put("432", d31);
        duplicates3.put("53", d32);
        duplicates3.put("236", d33);
        duplicates3.put("11", d34);

        System.out.println(findDuplicates(duplicates0));
        System.out.println(findDuplicates(duplicates1));
        System.out.println(findDuplicates(duplicates2));
        System.out.println(findDuplicates(duplicates3));
    }
}
