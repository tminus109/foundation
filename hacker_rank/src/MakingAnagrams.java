import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakingAnagrams {
    public static int makeAnagrams(String a, String b) {
        int deletionCount = 0;
        Map<Character, Integer> chars = new HashMap<>();

        for (char key : a.toCharArray()) {
            int value = chars.getOrDefault(key, 0);
            chars.put(key, (value + 1));
        }

        for (char key : b.toCharArray()) {
            int value = chars.getOrDefault(key, 0);
            chars.put(key, (value - 1));
        }

        List<Integer> values = new ArrayList<>(chars.values());

        for (Integer value : values) {
            deletionCount += Math.abs(value);
        }

        return deletionCount;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagrams("cde", "abc"));
        System.out.println(makeAnagrams("bacdc", "dcbac"));
        System.out.println(makeAnagrams("bacdc", "dcbad"));
    }
}
