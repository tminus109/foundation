package sprites;

import utilities.PositionedImage;

public class Skeleton extends Monster {
    public Skeleton(int[] startPos, int gameLevel, int id) {
        this.type = "Skeleton";
        this.file = "assets/skeleton.png";
        this.posX = startPos[0];
        this.posY = startPos[1];
        this.savedX = posX;
        this.savedY = posY;
        this.image = new PositionedImage(file, posX * tile, posY * tile);
        this.level = 1;
        this.maxHP = 2 * gameLevel * rollDice();
        this.HP = maxHP;
        this.DP = gameLevel / 2 * rollDice();
        this.SP = gameLevel * rollDice();
    }
}
