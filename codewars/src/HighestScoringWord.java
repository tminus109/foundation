import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {
    public static String findHighestScoringWord(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(a -> a.chars()
                        .map(i -> i - 96)
                        .sum()))
                .orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(findHighestScoringWord("a aa b bb"));
        System.out.println(findHighestScoringWord("abc bca"));
        System.out.println(findHighestScoringWord("rrr aaa bbb ccc rrr fff"));
        System.out.println(findHighestScoringWord("polar black sun brown sloth andean panda"));
    }
}
