package maze;

import utilities.PositionedImage;

import java.awt.*;

public class Tile {
    boolean isWall;
    PositionedImage image;
    String filename;

    public Tile(boolean isWall, int X, int Y) {
        this.isWall = isWall;
        if (isWall) {
            this.filename = "assets/wall_tile.png";
        } else {
            this.filename = "assets/floor_tile.png";
        }
        this.image = new PositionedImage(filename, X, Y);
    }

    public void drawTile(Graphics graphics) {
        image.draw(graphics);
    }
}
