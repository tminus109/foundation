package pirates;

public class BattleApp {
    public static void main(String[] args) {
        Ship blackPearl = new Ship("The Black Pearl");
        blackPearl.fillShip();
        blackPearl.captain.renameCaptain("Captain Jack Sparrow");
        blackPearl.getShipInfo();
        System.out.println();

        Ship cobra = new Ship("The Cobra");
        cobra.fillShip();
        cobra.captain.renameCaptain("Captain Barbosa");
        cobra.getShipInfo();
        System.out.println();

        blackPearl.battle(cobra);
        System.out.println();
        blackPearl.getShipInfo();
        System.out.println();
        cobra.getShipInfo();
    }
}
