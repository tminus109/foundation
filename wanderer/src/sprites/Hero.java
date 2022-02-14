package sprites;

import maze.Maze;
import utilities.Grid;
import utilities.PositionedImage;

public class Hero extends Sprite implements Grid {
    public Hero(Maze maze) {
        this.type = "Hero";
        this.file = "assets/hero_down.png";
        this.direction = "down";
        this.posX = maze.getFloorTiles().get(0)[0];
        this.posY = maze.getFloorTiles().get(0)[1];
        this.savedX = posX;
        this.savedY = posY;
        this.image = new PositionedImage(file, posX * tile, posY * tile);
        this.level = 1;
        this.maxHP = 20 + (3 * rollDice());
        this.HP = maxHP;
        this.DP = 2 * rollDice();
        this.SP = 5 + rollDice();
        maze.updateOccupiedTilesMap(this, posX, posY);
    }

    public String getFileMatchingDirection(String direction) {
        return switch (direction) {
            case "left" -> "assets/hero_left.png";
            case "right" -> "assets/hero_right.png";
            case "up" -> "assets/hero_up.png";
            case "down" -> "assets/hero_down.png";
            default -> "assets/floor_tile.png";
        };
    }

    public void levelUp() {
        this.level++;
    }
}
