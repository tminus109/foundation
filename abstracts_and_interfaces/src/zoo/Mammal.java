package zoo;

public class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "giving birth to live young";
    }
}
