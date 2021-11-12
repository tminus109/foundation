import java.util.HashMap;
import java.util.Map;

public class MapIntroduction1 {
    public static void main(String[] args) {
        Map<Integer, Character> m = new HashMap<>();
        m.put(97, 'a');
        m.put(98, 'b');
        m.put(99, 'c');
        m.put(65, 'A');
        m.put(66, 'B');
        m.put(67, 'C');

        System.out.println(m.keySet());
//        for (Integer key : m.keySet()) {
//            System.out.println(key);
//        }
        System.out.println(m.values());
//        for (Character value : m.values()) {
//            System.out.println(value);
//        }
        m.put(68, 'D');
        System.out.println(m.size());
        System.out.println(m.get(99));
        m.remove(97);
        System.out.println(m.containsKey(100));
        m.clear();
    }
}
