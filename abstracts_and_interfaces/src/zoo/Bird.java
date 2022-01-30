package zoo;

public class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }
}
