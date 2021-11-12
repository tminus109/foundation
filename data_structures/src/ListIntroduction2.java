import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListIntroduction2 {
    public static void main(String[] args) {
        List<String> A = new ArrayList<>(Arrays.asList("Apple", "Avocado", "Blueberries", "Durian"));
        List<String> B = new ArrayList<>(A);
        System.out.println(A.contains("Durian"));
        B.remove(3);
        A.add("Kiwifruit");
//        A.add(4, "Kiwifruit");
        System.out.println(A.equals(B));
        System.out.println(A.indexOf("Avocado"));
        System.out.println(B.indexOf("Durian"));
        B.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
//        Collections.addAll(B, "Passion Fruit", "Pomelo");
        System.out.println(A.get(2));
    }
}
