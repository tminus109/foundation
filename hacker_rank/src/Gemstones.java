import java.util.HashSet;
import java.util.Set;

public class Gemstones {
    public static int findGems(String[] rocks) {
        int gemCount = 0;
        String firstRock = rocks[0];
        int l = firstRock.length();
        int length = rocks.length;
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < l; i++) {
            char mineral = firstRock.charAt(i);
            if (!seen.contains(mineral)) {
                seen.add(mineral);
                int occCount = 0;
                for (String rock : rocks) {
                    if (rock.contains(Character.toString(firstRock.charAt(i)))) {
                        occCount++;
                    }
                }
                if (occCount == length) {
                    gemCount++;
                }
            }
        }

        return gemCount;
    }


    public static void main(String[] args) {
        System.out.println(findGems(new String[]{"abc", "abc", "bc"}));
        System.out.println(findGems(new String[]{"abcdde", "baccd", "eeabg"}));
        System.out.println(findGems(new String[]{"abcb", "abcb", "bcb"}));
    }
}
