package sprites;

import map.Map;
import utilities.Grid;
import utilities.PositionedImage;

public class Hero extends Sprite implements Grid {
    public Hero(int[] startPos) {
        this.type = "Hero";
        this.file = "assets/hero_down.png";
        this.direction = "down";
        this.posX = startPos[0];
        this.posY = startPos[1];
        this.savedX = posX;
        this.savedY = posY;
        this.image = new PositionedImage(file, posX * tile, posY * tile);
        this.level = 1;
        this.maxHP = 20 + (3 * rollDice());
        this.HP = maxHP;
        this.DP = 2 * rollDice();
        this.SP = 5 + rollDice();
    }

    public void move(String newDirection, Map map) {
        setSavedX(posX);
        setSavedY(posY);
        switch (newDirection) {
            case "left" -> {
                setFile("assets/hero_left.png");
                if (map.isTileOnFloor(posX - 1, posY)) {
                    posX--;
                }
            }
            case "right" -> {
                setFile("assets/hero_right.png");
                if (map.isTileOnFloor(posX + 1, posY)) {
                    posX++;
                }
            }
            case "up" -> {
                setFile("assets/hero_up.png");
                if (map.isTileOnFloor(posX, posY - 1)) {
                    posY--;
                }
            }
            case "down" -> {
                setFile("assets/hero_down.png");
                if (map.isTileOnFloor(posX, posY + 1)) {
                    posY++;
                }
            }
        }
        setImage(file, posX * tile, posY * tile);
    }

    public boolean canBeAttacked(int posX, int posY) {
        return occupiesTile(posX, posY) && !isFighting();
    }
}
