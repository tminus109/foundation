package instruments;

public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;

    abstract String sound();

    @Override
    public void play() {
        System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes "
                + sound() + ".");
    }
}
