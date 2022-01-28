package aircraft_carrier;

public class Aircraft {
    int ammo;
    int maxAmmo;
    int baseDamage;
    String type;

    Aircraft() {
        this.ammo = 0;
    }

    int fight() {
        int damage = baseDamage * ammo;
        ammo = 0;
        return damage;
    }

    int refillAmmo(int amount) {
        int ammoNeeded = maxAmmo - ammo;
        if (amount > ammoNeeded) {
            ammo += ammoNeeded;
            return amount - ammoNeeded;
        } else {
            ammo += amount;
        }
        return 0;
    }

    String getType() {
        return type;
    }

    String getStatus() {
        return "Type: " + type + ", Ammo: " + ammo + ", Base damage: " + baseDamage +
                ", All damage: " + baseDamage * ammo;
    }

    boolean isPriority() {
        return getType().equals("F35");
    }
}
