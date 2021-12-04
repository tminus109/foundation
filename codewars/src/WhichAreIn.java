import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhichAreIn {
    public static List<String> which(List<String> a1, List<String> a2) {
        List<String> r = new ArrayList<>();
        Collections.sort(a2);
        for (int i = 0; i < a1.size(); i++) {
            for (String s : a2) {
                if (a2.get(i).contains(s) && !r.contains(a1.get(i))) {
                    r.add(a1.get(i));
                    break;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        List<String> a1 = new ArrayList<>(Arrays.asList("arp", "live", "strong"));
        List<String> a2 = new ArrayList<>(Arrays.asList("lively", "alive", "harp", "sharp", "armstrong"));
        List<String> b1 = new ArrayList<>(Arrays.asList("tarp", "mice", "bull"));
        List<String> b2 = new ArrayList<>(Arrays.asList("lively", "alive", "harp", "sharp", "armstrong"));

        System.out.println(which(a1, a2));
        System.out.println(which(b1, b2));
    }
}
