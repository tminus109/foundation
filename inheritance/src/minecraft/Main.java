package minecraft;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Wall wall = new Wall();

        wall.placeBlock(new Air());
        wall.placeBlock(new Brick(Color.DARK_GRAY));
        wall.placeBlock(new Door(2, "Mordor", Color.BLACK, 60));
        wall.placeBlock(new Glass(80));
        wall.placeBlock(new Glowstone());
        wall.placeBlock(new Window(1, "Lilliput", Color.WHITE, 70, true));
        wall.placeBlock(new Window(2, "Asgard", Color.LIGHT_GRAY, 90, true));
        wall.placeBlock(new Mud());
        wall.placeBlock(new Gold(50));
        wall.placeBlock(new Lava());
        wall.placeBlock(new Glowstone());
        wall.placeBlock(new Ice());
        wall.placeBlock(new Lava());
        wall.placeBlock(new Gold(30));
        wall.placeBlock(new Ice());

        wall.printStatus();
    }
}
