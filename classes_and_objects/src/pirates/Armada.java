package pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
    String name;
    List<Ship> ships;

    Armada(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    void addShipToArmada(Ship ship) {
        ships.add(ship);
    }

    int calculateArmadaStrength() {
        int armadaStrength = 0;
        for (Ship ship : ships) {
            armadaStrength += ship.calculateShipStrength();
        }
        return armadaStrength;
    }

    void getArmadaInfo() {
        System.out.println(name);
        System.out.println("The " + name + " armada has " + ships.size() + " ship(s).");
        System.out.println("The " + name + " armada is " + calculateArmadaStrength() + " strong.\n");
    }

    void destroyShip(int n) {
        ships.remove(n);
    }

    void war(Armada otherArmada) {
        System.out.println("THE " + name + " AND THE " + otherArmada.name + " ARE IN WAR!\n");
        while (ships.size() > 0 && otherArmada.ships.size() > 0) {
            Ship nextShip = ships.get(0);
            Ship nextEnemyShip = otherArmada.ships.get(0);
            nextShip.battle(nextEnemyShip);
            if (!nextShip.captain.alive) {
                destroyShip(0);
            } else if (!nextEnemyShip.captain.alive) {
                otherArmada.destroyShip(0);
            }
            getArmadaInfo();
            otherArmada.getArmadaInfo();
        }
        if (ships.size() > 0) {
            System.out.println("THE " + name + " WON THE WAR, HOORAY!");
        } else if (otherArmada.ships.size() > 0) {
            System.out.println("THE " + otherArmada.name + " WON THE WAR : (");
        }
    }
}
