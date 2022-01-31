import java.util.HashMap;

public class CountLetters {
    HashMap<Character, Integer> dictionary(String string) {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (!dictionary.containsKey(string.charAt(i))) {
                dictionary.put(string.charAt(i), 1);
            } else {
                int value = dictionary.get(string.charAt(i)) + 1;
                dictionary.put(string.charAt(i), value);
            }
        }
        return dictionary;
    }
}
