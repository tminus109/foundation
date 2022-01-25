package pirates;

public class Captain extends Pirate {
    String name;

    Captain(String name) {
        this.name = name;
    }

    void renameCaptain(String name) {
        this.name = name;
    }

    @Override
    void die() {
        if (alive) {
            alive = false;
        } else {
            System.out.println("He's dead already.");
        }
        renameCaptain("a dead man");
    }
}
