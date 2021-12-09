public class MatchesOrMore {
    String name;

    //    bot
    public MatchesOrMore(String name) {
        this.name = name;
    }

    public int makeMove(int matches, int takes) {
        int min = 1;
        int max = Math.min(matches, takes);
        int range = max - min + 1;
        int move = (int) (Math.random() * range) + 1;
        matches -= move;
        System.out.println(this.name + " took " + move + "match(es), there are " + matches + " match(es) left");
        if (matches == 0) {
            System.out.println(this.name + " lost : (");
        }
        return matches;
    }

    public static void battle(int matches, int takes, MatchesOrMore bot1, MatchesOrMore bot2) {
        while (matches > 0) {
            matches = bot1.makeMove(matches, takes);
            if (matches > 0) {
                matches = bot2.makeMove(matches, takes);
            }
        }
    }

    public static void main(String[] args) {
        int matches = 13;
        int takes = 4;
        MatchesOrMore bot1 = new MatchesOrMore("bot1");
        MatchesOrMore bot2 = new MatchesOrMore("bot2");

        battle(matches, takes, bot1, bot2);
    }
}
