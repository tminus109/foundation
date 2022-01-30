package instruments;

public class ElectricGuitar extends StringedInstrument {
    public ElectricGuitar(int numberOfStrings) {
        this.name = "Electric Guitar";
        this.numberOfStrings = numberOfStrings;
    }

    public ElectricGuitar() {
        this.name = "Electric Guitar";
        this.numberOfStrings = 6;
    }

    @Override
    String sound() {
        return "Twang";
    }
}
