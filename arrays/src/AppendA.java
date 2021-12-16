import java.util.Arrays;

public class AppendA {
    public static void main(String[] args) {
        String[] animals = {"koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr", "gorill", "hyen", "hydr",
                "iguan", "impal", "pum", "tarantul", "pirahn"};
        for (int i = 0; i < animals.length; i++) {
            animals[i] += "a";
        }
        System.out.println(Arrays.toString(animals));
    }
}
