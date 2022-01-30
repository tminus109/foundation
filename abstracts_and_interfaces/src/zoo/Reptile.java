package zoo;

public class Reptile extends Animal {
    Reptile(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }
}
