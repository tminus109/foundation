package zoo;

public class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    @Override
    String breed() {
        return "laying eggs";
    }
}
