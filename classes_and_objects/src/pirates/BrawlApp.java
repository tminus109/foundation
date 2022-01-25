package pirates;

public class BrawlApp {
    public static void main(String[] args) {
        Pirate pirate = new Pirate();
        Pirate pirate1 = new Pirate();
        Pirate pirate2 = new Pirate();

        System.out.println(pirate.alive);
        System.out.println(pirate.intoxicationLevel);
        System.out.println(pirate.strength);
        System.out.println();

        pirate.drinkSomeRum();
        System.out.println(pirate.intoxicationLevel);
        System.out.println(pirate.strength);
        System.out.println();

        pirate.howsItGoingMate();
        pirate.howsItGoingMate();
        pirate.howsItGoingMate();
        pirate.howsItGoingMate();
        System.out.println(pirate.intoxicationLevel);
        System.out.println(pirate.strength);
        System.out.println();

        pirate.brawl(pirate1);
        System.out.println();

        pirate2.die();
        pirate2.drinkSomeRum();
        pirate2.howsItGoingMate();
        pirate2.passOut();
        pirate2.brawl(pirate);
    }
}
