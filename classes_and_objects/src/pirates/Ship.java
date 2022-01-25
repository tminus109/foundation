package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    String name;
    Captain captain;
    List<Pirate> pirates;

    Ship(String name) {
        this.name = name;
        this.captain = new Captain("Captain");
        this.pirates = new ArrayList<>();
    }

    void fillShip() {
        Random random = new Random();
        int numOfPirates = random.nextInt(114);
        for (int i = 0; i < numOfPirates; i++) {
            pirates.add(new Pirate());
        }
    }

    int getDrunkPiratesCount() {
        int drunkPiratesCount = 0;
        for (Pirate pirate : pirates) {
            if (pirate.intoxicationLevel != 0) {
                drunkPiratesCount++;
            }
        }
        if (captain.intoxicationLevel != 0) {
            drunkPiratesCount++;
        }
        return drunkPiratesCount;
    }

    int calculateShipStrength() {
        int shipStrength = 0;
        for (Pirate pirate : pirates) {
            shipStrength += pirate.strength;
        }
        return shipStrength;
    }

    void getShipInfo() {
        System.out.println(name);
        System.out.println("The captain is " + captain.name + ".");
        System.out.println("There are " + pirates.size() + " pirate(s) on board.");
        System.out.println(getDrunkPiratesCount() + " pirate(s) are drunk.");
        System.out.println("This ship is " + calculateShipStrength() + " strong.");
        System.out.println();
    }

    void party() {
        Random random = new Random();
        for (Pirate pirate : pirates) {
            int rumQuantity = random.nextInt(5);
            for (int j = 0; j < rumQuantity; j++) {
                pirate.drinkSomeRum();
            }
        }
        captain.drinkSomeRum();
    }

    void battle(Ship otherShip) {
        String winner = "";
        if (calculateShipStrength() > otherShip.calculateShipStrength()) {
            winner = name;
            otherShip.pirates.clear();
            otherShip.captain.die();
            int lostCrewCount = pirates.size() / 3;
            for (int i = 0; i < lostCrewCount; i++) {
                pirates.remove(pirates.get(i));
            }
            party();
        } else {
            winner = otherShip.name;
            pirates.clear();
            captain.die();
            int lostCrewCount = otherShip.pirates.size() / 3;
            for (int i = 0; i < lostCrewCount; i++) {
                otherShip.pirates.remove(otherShip.pirates.get(i));
            }
            otherShip.party();
        }
        System.out.println(name + " attacked " + otherShip.name + ".");
        System.out.println("After a long, ferocious fight, " + winner + " won.\n");
    }
}
