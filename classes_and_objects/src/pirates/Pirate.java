package pirates;

import java.util.Random;

public class Pirate {
    int intoxicationLevel;
    int strength;
    boolean alive;

    Pirate() {
        this.intoxicationLevel = 0;
        this.strength = 4;
        this.alive = true;
    }

    void drinkSomeRum() {
        if (alive) {
            intoxicationLevel++;
            strength--;
        } else {
            System.out.println("He is dead.");
        }
    }

    void howsItGoingMate() {
        if (alive) {
            if (intoxicationLevel < 4) {
                System.out.println("Pour me anudder!");
                drinkSomeRum();
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                passOut();
            }
        } else {
            System.out.println("He is dead.");
        }
    }

    void passOut() {
        if (alive) {
            System.out.println("Zzz...");
            intoxicationLevel = 0;
            strength = 4;
        } else {
            System.out.println("He is dead.");
        }
    }

    void brawl(Pirate otherPirate) {
        if (alive && otherPirate.alive) {
            if (strength > otherPirate.strength) {
                strength -= otherPirate.strength;
                otherPirate.die();
                System.out.println("You won, the other pirate died.");
            } else if (otherPirate.strength > strength) {
                otherPirate.strength -= strength;
                die();
                System.out.println("You died.");
            } else {
                Random random = new Random();
                int whoDies = random.nextInt(3);
                if (whoDies == 0) {
                    System.out.println("Go to sleep, both of you!");
                    passOut();
                    otherPirate.passOut();
                } else if (whoDies == 1) {
                    die();
                    System.out.println("You died.");
                } else {
                    otherPirate.die();
                    System.out.println("You won, the other pirate died.");
                }
            }
        } else if (!alive && otherPirate.alive) {
            System.out.println("This pirate is dead.");
        } else if (alive) {
            System.out.println("The pirate you want to fight is dead.");
        } else {
            System.out.println("Both pirates are dead.");
        }
    }

    void die() {
        if (alive) {
            alive = false;
        } else {
            System.out.println("He's dead already.");
        }
    }
}
