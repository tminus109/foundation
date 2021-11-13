import java.util.ArrayList;
import java.util.Arrays;

public class MostFrequentWord {
    public static ArrayList<String> findMostFrequentWords(String input) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(input
                .toLowerCase()
                .replaceAll("\n", " ")
                .replaceAll("[^a-z A-Z]", "")
                .split(" ")));
        ArrayList<String> uniqueWords = new ArrayList<>();
        for (String s : words) {
            if (!uniqueWords.contains(s)) {
                uniqueWords.add(s);
            }
        }
        ArrayList<Integer> uniqueWordsCount = new ArrayList<>();
        for (String uniqueWord : uniqueWords) {
            int count = 0;
            for (String word : words) {
                if (uniqueWord.equals(word)) {
                    count++;
                }
            }
            uniqueWordsCount.add(count);
        }
        int value = uniqueWordsCount.get(0);
        for (int i = 0; i < uniqueWordsCount.size() - 1; i++) {
            if (uniqueWordsCount.get(i + 1) > value) {
                value = uniqueWordsCount.get(i + 1);
            }
        }
        ArrayList<String> mostFrequentWords = new ArrayList<>();
        for (int i = 0; i < uniqueWordsCount.size(); i++) {
            if (uniqueWordsCount.get(i) == value) {
                mostFrequentWords.add(uniqueWords.get(i));
            }
        }
        return mostFrequentWords;
    }

    public static void main(String[] args) {
        String input = """
                But then they were married (she felt awful about being pregnant before but
                Harry had been talking about marriage for a while and anyway laughed when
                she told him in early February about missing her period and said Great she
                was terribly frightened and he said Great and lifted her put his arms around
                under her bottom and lifted her like you would a child he could be so
                wonderful when you didn’t expect it in a way it seemed important that you
                didn’t expect it there was so much nice in him she couldn’t explain to
                anybody she had been so frightened about being pregnant and he made her
                be proud) they were married after her missing her second period in March
                and she was still little clumsy dark-complected Janice Springer and her
                husband was a conceited lunk who wasn’t good for anything in the world Daddy
                said and the feeling of being alone would melt a little with a little drink.""";

        System.out.println(findMostFrequentWords(input));
    }
}
