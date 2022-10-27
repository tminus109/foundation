public class Gemstones {
    public static int findGems(String[] rocks) {
        int gemCount = 0;
        int length = rocks.length;
        String firstRock = rocks[0];
        int l = firstRock.length();

        for (int i = 0; i < l; i++) {
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

        return gemCount;
    }


    public static void main(String[] args) {
        System.out.println(findGems(new String[]{"abc", "abc", "bc"}));
        System.out.println(findGems(new String[]{"abcdde", "baccd", "eeabg"}));
    }
}
