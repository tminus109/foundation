package pirates;

public class WarApp {
    public static void main(String[] args) {
        Armada armada = new Armada("Pirates");
        Ship ship = new Ship("The Black Pearl");
        Ship ship1 = new Ship("The Black Crow");
        Ship ship2 = new Ship("The Black Death");
        ship.captain.renameCaptain("Jack Sparrow");
        ship1.captain.renameCaptain("Barbosa");
        ship2.captain.renameCaptain("Little John");
        ship.fillShip();
        ship1.fillShip();
        ship2.fillShip();
        armada.addShipToArmada(ship);
        armada.addShipToArmada(ship1);
        armada.addShipToArmada(ship2);
        armada.getArmadaInfo();

        Armada armada1 = new Armada("Soldiers");
        Ship ship3 = new Ship("The White Maiden");
        Ship ship4 = new Ship("The White Esmeralda");
        Ship ship5 = new Ship("The White Pearl");
        ship3.captain.renameCaptain("Morris");
        ship4.captain.renameCaptain("Smith");
        ship5.captain.renameCaptain("Gilmore");
        ship3.fillShip();
        ship4.fillShip();
        ship5.fillShip();
        armada1.addShipToArmada(ship3);
        armada1.addShipToArmada(ship4);
        armada1.addShipToArmada(ship5);
        armada1.getArmadaInfo();

        armada.war(armada1);
    }
}
