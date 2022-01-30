package zoo;

public abstract class Animal {
    String name;
    int age;
    String gender;
    String color;
    boolean predator;
    boolean canFly;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String breed();
}
