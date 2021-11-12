import java.util.HashMap;
import java.util.Map;

public class MapIntroduction1 {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(97, 'a');
        map.put(99, 'c');
        map.put(65, 'A');
        map.put(66, 'B');
        map.put(67, 'C');

        System.out.println(map.keySet());
//        for (Integer key : map.keySet()) {
//            System.out.println(key);
//        }
        System.out.println(map.values());
//        for (Character value : map.values()) {
//            System.out.println(value);
//        }
        map.put(68, 'D');
        System.out.println(map.size());
        System.out.println(map.get(99));
        map.remove(97);
        System.out.println(map.containsKey(100));
        map.clear();
    }
}
