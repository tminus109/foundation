import java.util.*;

public class HighestScoringWord {
    public static String highestScoringWord(String s) {
        String theWord = "";
        Map<Character, Integer> points = new HashMap<>();
        int point = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            point++;
            points.put(ch, point);
        }

        List<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
        int score = 0;

        for (String word : words) {
            int temp = 0;
            for (int j = 0; j < word.length(); j++) {
                temp += points.get(word.charAt(j));
            }
            if (temp > score) {
                score = temp;
                theWord = word;
            }
        }

        return theWord;
    }

    public static void main(String[] args) {
        String s0 = "a aa b bb";
        String s1 = "abc bca";
        String s2 = "rrr aaa bbb ccc rrr fff";

        System.out.println(highestScoringWord(s0));
        System.out.println(highestScoringWord(s1));
        System.out.println(highestScoringWord(s2));
    }
}
