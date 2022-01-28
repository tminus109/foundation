package aircraft_carrier;

public class Main {
    public static void main(String[] args) {
        Carrier carrier = new Carrier("Eisenhower", 300, 3000);
        carrier.add(new F16());
        carrier.add(new F35());
        carrier.add(new F16());
        carrier.add(new F35());
        carrier.add(new F16());
        carrier.add(new F35());
        carrier.fill();
        carrier.getStatus();

        Carrier carrier1 = new Carrier("Admiral Kuznetsov", 320, 2900);
        carrier1.add(new F16());
        carrier1.add(new F35());
        carrier1.add(new F16());
        carrier1.add(new F35());
        carrier1.add(new F16());
        carrier1.add(new F35());
        carrier1.fill();
        carrier1.getStatus();

        carrier.fight(carrier1);
        carrier.fill();
        carrier.fight(carrier1);
        carrier.fill();
        carrier.getStatus();
    }
}
