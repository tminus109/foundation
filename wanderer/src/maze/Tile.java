package maze;

import utilities.PositionedImage;

import java.awt.*;

public class Tile {
    boolean isWall;
    PositionedImage image;
    String filename;

    Tile(boolean isWall, int posX, int posY) {
        this.isWall = isWall;
        if (isWall) {
            this.filename = "assets/wall_tile.png";
        } else {
            this.filename = "assets/floor_tile.png";
        }
        this.image = new PositionedImage(filename, posX, posY);
    }

    void drawTile(Graphics graphics) {
        image.draw(graphics);
    }
}
