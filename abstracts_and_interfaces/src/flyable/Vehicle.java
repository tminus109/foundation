package flyable;

public abstract class Vehicle {
    String type;
    String color;
    int weight;

    public Vehicle(String type, String color, int weight) {
        this.type = type;
        this.color = color;
        this.weight = weight;
    }
}
