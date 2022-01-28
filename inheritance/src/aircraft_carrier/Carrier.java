package aircraft_carrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    String name;
    List<Aircraft> aircraftList;
    int ammoStorage;
    int healthPoint;

    Carrier(String name, int ammo, int healthPoint) {
        this.name = name;
        this.aircraftList = new ArrayList<>();
        this.ammoStorage = ammo;
        this.healthPoint = healthPoint;
    }

    void add(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    void fill() {
        for (Aircraft aircraft : aircraftList) {
            if (ammoStorage == 0) {
                System.out.println("Sorry, the carrier is out of ammo!");
            } else if (aircraft.isPriority()) {
                ammoStorage = aircraft.refillAmmo(ammoStorage);
            }
        }
        for (Aircraft aircraft : aircraftList) {
            if (ammoStorage == 0) {
                System.out.println("Sorry, the carrier is out of ammo!");
            } else {
                ammoStorage = aircraft.refillAmmo(ammoStorage);
            }
        }
    }

    void fight(Carrier otherCarrier) {
        System.out.println(name + " ATTACKED " + otherCarrier.name + "!\n");
        for (Aircraft aircraft : aircraftList) {
            otherCarrier.healthPoint -=
                    aircraft.fight();
            aircraft.ammo = 0;
        }
        getStatus();
        otherCarrier.getStatus();
    }

    int getTotalDamage() {
        int totalDamage = 0;
        for (Aircraft aircraft : aircraftList) {
            totalDamage += aircraft.ammo * aircraft.baseDamage;
        }
        return totalDamage;
    }

    void getStatus() {
        if (healthPoint <= 0) {
            System.out.println(name + ": It's dead Jim...\n");
        } else {
            System.out.println(name + ": HP: " + healthPoint + ", Aircraft count: " + aircraftList.size()
                    + ", Ammo storage: " + ammoStorage + ", Total damage: " + getTotalDamage());
            System.out.println("Aircraft:");
            for (Aircraft aircraft : aircraftList) {
                System.out.println(aircraft.getStatus());
            }
            System.out.println();
        }
    }
}
