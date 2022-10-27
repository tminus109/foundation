import java.util.ArrayList;
import java.util.Arrays;

public class RansomNote {
    public static void matchWords(String m, String n) {
        ArrayList<String> wordsOfMagazine = new ArrayList<>(Arrays.asList(m.split(" ")));
        ArrayList<String> wordsOfNote = new ArrayList<>(Arrays.asList(n.split(" ")));
        boolean yesOrNo = true;

        for (String s : wordsOfNote) {
            if (!wordsOfMagazine.contains(s)) {
                yesOrNo = false;
                break;
            }
        }

        if (yesOrNo) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        matchWords("give me one grand today night", "give one grand today");
        matchWords("two times three is not four", "two times two is four");
        matchWords("I've got a lovely bunch of coconuts", "I've got some coconuts");
        matchWords("attack at dawn", "Attack at dawn");
    }
}
