package instruments;

public class BassGuitar extends StringedInstrument {
    public BassGuitar(int numberOfStrings) {
        this.name = "Bass Guitar";
        this.numberOfStrings = numberOfStrings;
    }

    public BassGuitar() {
        this.name = "Bass Guitar";
        this.numberOfStrings = 4;
    }

    @Override
    String sound() {
        return "Duum-duum-duum";
    }
}
