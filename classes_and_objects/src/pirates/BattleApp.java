package pirates;

public class BattleApp {
    public static void main(String[] args) {
        Ship blackPearl = new Ship("The Black Pearl");
        blackPearl.fillShip();
        blackPearl.captain.renameCaptain("Jack Sparrow");
        blackPearl.getShipInfo();

        Ship cobra = new Ship("The Cobra");
        cobra.fillShip();
        cobra.captain.renameCaptain("Barbosa");
        cobra.getShipInfo();

        blackPearl.battle(cobra);
        blackPearl.getShipInfo();
        cobra.getShipInfo();
    }
}
