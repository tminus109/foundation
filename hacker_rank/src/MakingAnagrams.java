import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakingAnagrams {
    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char key : a.toCharArray()) {
            int value = charCount.containsKey(key) ? charCount.get(key) : 0;
            charCount.put(key, (value + 1));
        }

        for (char key : b.toCharArray()) {
            int value = charCount.containsKey(key) ? charCount.get(key) : 0;
            charCount.put(key, (value - 1));
        }

        List<Integer> values = new ArrayList<>(charCount.values());
        int totalCharsDeleted = 0;
        for (Integer v : values) {
            totalCharsDeleted += Math.abs(v);
        }

        return totalCharsDeleted;
    }

    public static void main(String[] args) {
        String a = "cde";
        String b = "abc";
        String a2 = "bacdc";
        String b2 = "dcbac";
        String a3 = "bacdc";
        String b3 = "dcbad";

        System.out.println(makeAnagram(a, b));
        System.out.println(makeAnagram(a2, b2));
        System.out.println(makeAnagram(a3, b3));
    }
}
