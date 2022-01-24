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
            this.pirates.add(new Pirate());
        }
    }

    int getDrunkPiratesCount() {
        int drunkPiratesCount = 0;
        for (Pirate pirate : this.pirates) {
            if (pirate.drunkennessLevel != 0) {
                drunkPiratesCount++;
            }
        }
        if (captain.drunkennessLevel != 0) {
            drunkPiratesCount++;
        }
        return drunkPiratesCount;
    }

    int calculateShipStrength() {
        int shipStrength = 0;
        for (Pirate pirate : this.pirates) {
            shipStrength += pirate.strength;
        }
        return shipStrength;
    }

    void getShipInfo() {
        System.out.println(this.name);
        System.out.println("The captain is " + this.captain.name + ".");
        System.out.println("There are " + this.pirates.size() + " pirates on board.");
        System.out.println(this.getDrunkPiratesCount() + " pirates are drunk.");
        System.out.println("This ship is " + this.calculateShipStrength() + " strong.");
    }

    void party() {
        Random random = new Random();
        for (Pirate pirate : this.pirates) {
            int rumQuantity = random.nextInt(5);
            for (int j = 0; j < rumQuantity; j++) {
                pirate.drinkSomeRum();
            }
        }
    }

    void battle(Ship otherShip) {
        String winner = "";
        Random random = new Random();
        if (this.calculateShipStrength() > otherShip.calculateShipStrength()) {
            winner = this.name;
            otherShip.pirates.clear();
            otherShip.captain.die();
            int lostCrewCount = random.nextInt(this.pirates.size() / 2 - 1);
            for (int i = 0; i < lostCrewCount; i++) {
                this.pirates.remove(this.pirates.get(i));
            }
            this.party();
            this.captain.drinkSomeRum();
        } else {
            winner = otherShip.name;
            this.pirates.clear();
            this.captain.die();
            int lostCrewCount = random.nextInt(otherShip.pirates.size() / 2 - 1);
            for (int i = 0; i < lostCrewCount; i++) {
                otherShip.pirates.remove(otherShip.pirates.get(i));
            }
            otherShip.party();
            otherShip.captain.drinkSomeRum();
        }
        System.out.println(this.name + " and " + otherShip.name
                + " just had a battle. After long, ferocious fighting "
                + winner + " won.");
    }
}
