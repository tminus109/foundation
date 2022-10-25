public class MatchesOrMoreBot {
    String name;

    public MatchesOrMoreBot(String name) {
        this.name = name;
    }

    public int takeSomeMatchesAway(int matchCount, int maxTake) {
        int randomTake = (int) ((Math.random() * (maxTake - 1)) + 1);
        int take = Math.min(matchCount, randomTake);
        matchCount -= take;
        System.out.println(this.name + " took " + take + " match(es) away, there are " + matchCount + " match(es) left.");
        if (matchCount == 0) {
            System.out.println(this.name + " lost : (");
        }
        return matchCount;
    }

    public static void play(int matchCount, int maxTake, MatchesOrMoreBot bot1, MatchesOrMoreBot bot2) {
        System.out.println("There are " + matchCount + " match(es) on the table. The maximum take is " + maxTake + ".");
        while (matchCount > 0) {
            matchCount = bot1.takeSomeMatchesAway(matchCount, maxTake);
            if (matchCount > 0) {
                matchCount = bot2.takeSomeMatchesAway(matchCount, maxTake);
            }
        }
    }

    public static void main(String[] args) {
        int matchCount = 13;
        int maxTake = 4;
        MatchesOrMoreBot bot1 = new MatchesOrMoreBot("C3PO");
        MatchesOrMoreBot bot2 = new MatchesOrMoreBot("R2D2");

        play(matchCount, maxTake, bot1, bot2);
    }
}
