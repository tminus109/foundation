import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppendLetter {
    public static List<String> appendA(List<String> input) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            output.add(input.get(i) + "a");
//            output.add(input.get(i).concat("a"));
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> animals = Arrays.asList
                ("koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr", "gorill", "hyen",
                        "hydr", "iguan", "impal", "pum", "tarantul", "pirahn");
        System.out.println(appendA(animals));
    }
}
