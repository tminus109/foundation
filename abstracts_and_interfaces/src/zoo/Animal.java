package zoo;

public abstract class Animal {
    String name;
    int age;
    String gender;
    String color;
    boolean predator;
    boolean canFly;

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract String breed();
}
