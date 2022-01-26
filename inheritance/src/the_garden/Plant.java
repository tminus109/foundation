package the_garden;

public class Plant {
    String color;
    String type;
    double waterLevel;
    double absorbance;
    double thirstLevel;

    Plant(String color) {
        this.color = color;
        this.waterLevel = 0;
    }

    boolean needsWater() {
        return waterLevel < thirstLevel;
    }

    void drink(int amount) {
        waterLevel += amount;
    }

    void stateOfPlant() {
        if (needsWater()) {
            System.out.println("This " + color + " " + type + " needs water.");
        } else {
            System.out.println("This " + color + " " + type + " doesn't need any water.");
        }
        System.out.println("Water level: " + waterLevel);
        System.out.println("Thirst level: " + thirstLevel + "\n");
    }
}
