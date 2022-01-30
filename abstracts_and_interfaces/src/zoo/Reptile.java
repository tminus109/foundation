package zoo;

public class Reptile extends Animal {
    Reptile(String name) {
        super(name);
    }

    @Override
    String breed() {
        return "laying eggs";
    }
}
