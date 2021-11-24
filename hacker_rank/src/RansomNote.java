import java.util.ArrayList;
import java.util.Arrays;

public class RansomNote {
    public static void checkMagazine(String m, String n) {
        ArrayList<String> wordsOfMagazine = new ArrayList<>(Arrays.asList(m.split(" ")));
        ArrayList<String> wordsOfNote = new ArrayList<>(Arrays.asList(n.split(" ")));
        boolean yesOrNo = true;

        for (String s : wordsOfNote) {
            if (!wordsOfMagazine.contains(s)) {
                yesOrNo = false;
                break;
            } else {
                wordsOfMagazine.remove(s);
            }
        }

        if (yesOrNo) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        String m0 = "give me one grand today night";
        String n0 = "give one grand today";
        String m1 = "two times three is not four";
        String n1 = "two times two is four";
        String m2 = "ive got a lovely bunch of coconuts";
        String n2 = "ive got some coconuts";
        String m3 = "attack at dawn";
        String n3 = "Attack at dawn";

        checkMagazine(m0, n0);
        checkMagazine(m1, n1);
        checkMagazine(m2, n2);
        checkMagazine(m3, n3);
    }
}
