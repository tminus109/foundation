package instruments;

public class Violin extends StringedInstrument {
    public Violin() {
        this.name = "Violin";
        this.numberOfStrings = 4;
    }

    @Override
    String sound() {
        return "Screech";
    }
}
