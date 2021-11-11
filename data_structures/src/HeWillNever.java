import java.util.HashMap;
import java.util.Map;

public class HeWillNever {
    public static void messageDecoder(int[] notSoCrypticMessage) {
        StringBuilder out = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();

        map.put(7, "run around and desert you");
        map.put(50, "tell a lie and hurt you ");
        map.put(49, "make you cry, ");
        map.put(2, "let you down");
        map.put(12, "give you up, ");
        map.put(1, "Never gonna ");
        map.put(11, "\n");
        map.put(3, "say goodbye ");

        for (int j : notSoCrypticMessage) {
            out.append(map.get(j));
        }
        System.out.println(out);
    }

    public static void main(String[] args) {
        int[] notSoCrypticMessage = {1, 12, 1, 2, 11, 1, 7, 11, 1, 49, 1, 3, 11, 1, 50, 11};
        messageDecoder(notSoCrypticMessage);
    }
}
