package flyable;

public abstract class Vehicle {
    String type;
    String color;
    int weight;

    Vehicle(String type, String color, int weight) {
        this.type = type;
        this.color = color;
        this.weight = weight;
    }
}
