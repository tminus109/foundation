import java.util.ArrayList;
import java.util.List;

public class WhichAreIn {
    public static List<String> findWhichAreIn(String[] a1, String[] a2) {
        List<String> r = new ArrayList<>();

        for (String word : a1) {
            for (String s : a2) {
                if (s.contains(word)) {
                    r.add(word);
                    break;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {
        String[] a1 = {"arp", "live", "strong"};
        String[] a2 = {"lively", "alive", "harp", "sharp", "armstrong"};
        String[] b1 = {"tarp", "mice", "bull"};
        String[] b2 = {"lively", "alive", "harp", "sharp", "armstrong"};

        System.out.println(findWhichAreIn(a1, a2));
        System.out.println(findWhichAreIn(b1, b2));
    }
}
