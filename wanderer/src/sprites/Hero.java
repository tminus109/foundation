package sprites;

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

    public void move(String newDirection, boolean[][] maze) {
        setSavedX(posX);
        setSavedY(posY);
        switch (newDirection) {
            case "left" -> {
                setFile("assets/hero_left.png");
                if (posX - 1 >= 0 && !maze[posX - 1][posY]) {
                    posX--;
                }
            }
            case "right" -> {
                setFile("assets/hero_right.png");
                if (posX + 1 < grid && !maze[posX + 1][posY]) {
                    posX++;
                }
            }
            case "up" -> {
                setFile("assets/hero_up.png");
                if (posY - 1 >= 0 && !maze[posX][posY - 1]) {
                    posY--;
                }
            }
            case "down" -> {
                setFile("assets/hero_down.png");
                if (posY + 1 < grid && !maze[posX][posY + 1]) {
                    posY++;
                }
            }
        }
        setImage(file, posX * tile, posY * tile);
    }
}
