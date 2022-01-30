package flyable;

public class Helicopter extends Vehicle implements Flyable {
    public Helicopter(String type, String color, int weight) {
        super(type, color, weight);
    }

    @Override
    public void land() {
        System.out.println("This helicopter is landing.");
    }

    @Override
    public void fly() {
        System.out.println("This helicopter is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("This helicopter is taking off.");
    }
}
