package map;

import utilities.PositionedImage;

import java.awt.*;

public class Tile {
    boolean isWall;
    PositionedImage image;

    public Tile(boolean isWall, int X, int Y) {
        this.isWall = isWall;
        String filename = "assets/wall_tile.png";
        if (!isWall) {
            filename = "assets/floor_tile.png";
        }
        this.image = new PositionedImage(filename, X, Y);
    }

    public void drawTile(Graphics graphics) {
        image.draw(graphics);
    }
}
