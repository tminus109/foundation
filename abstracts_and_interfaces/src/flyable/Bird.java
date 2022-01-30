package flyable;

import zoo.Animal;

public class Bird extends Animal implements Flyable {
    Bird(String name) {
        super(name);
    }

    @Override
    public void land() {
        System.out.println("This bird is landing.");
    }

    @Override
    public void fly() {
        System.out.println("This bird is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("This bird is taking off.");
    }

    @Override
    public String breed() {
        return "laying eggs";
    }
}
