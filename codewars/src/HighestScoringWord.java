import java.util.*;

public class HighestScoringWord {
    public static String findHighestScoringWord(String s) {
        Map<Character, Integer> scoreOfEachWord = new HashMap<>();
        int scoreOfLetter = 1;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            scoreOfEachWord.put(ch, scoreOfLetter);
            scoreOfLetter++;
        }

        List<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
        String highestScoringWord = "";
        int score = 0;

        for (String word : words) {
            int tempScore = 0;
            for (int j = 0; j < word.length(); j++) {
                tempScore += scoreOfEachWord.get(word.charAt(j));
            }
            if (tempScore > score) {
                score = tempScore;
                highestScoringWord = word;
            }
        }

        return highestScoringWord;
    }

    public static void main(String[] args) {
        System.out.println(findHighestScoringWord("a aa b bb"));
        System.out.println(findHighestScoringWord("abc bca"));
        System.out.println(findHighestScoringWord("rrr aaa bbb ccc rrr fff"));
        System.out.println(findHighestScoringWord("polar black sun brown sloth andean panda"));
    }
}
