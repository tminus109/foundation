import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
    public static String compareStrings(String s1, String s2) {
        Set<Character> s1Set = new HashSet<>();
        Set<Character> s2Set = new HashSet<>();

        for (char c : s1.toCharArray()) {
            s1Set.add(c);
        }

        for (char c : s2.toCharArray()) {
            s2Set.add(c);
        }

        s1Set.retainAll(s2Set);

        if (!s1Set.isEmpty())
            return "YES";

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("hello", "world"));
        System.out.println(compareStrings("hi", "world"));
    }
}
