package zoo;

public class Mammal extends Animal {
    Mammal(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "giving birth to live young";
    }
}
