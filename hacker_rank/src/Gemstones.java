public class Gemstones {
    public static int gemstones(String[] rocks) {
        int gemstones = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = 0;
            for (String rock : rocks) {
                if (rock.contains(String.valueOf(ch))) {
                    count++;
                }
            }
            if (count == rocks.length) {
                gemstones++;
            }
        }

        return gemstones;
    }


    public static void main(String[] args) {
        String[] rocks0 = {"abc", "abc", "bc"};
        String[] rocks1 = {"abcdde", "baccd", "eeabg"};

        System.out.println(gemstones(rocks0));
        System.out.println(gemstones(rocks1));
    }
}
