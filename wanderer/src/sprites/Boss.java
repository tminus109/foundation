package sprites;

import utilities.PositionedImage;

public class Boss extends Monster {
    public Boss(int[] startPos, int tileSize, int gameLevel) {
        this.type = "Boss";
        this.file = "assets/boss.png";
        this.posX = startPos[0];
        this.posY = startPos[1];
        this.savedX = posX;
        this.savedY = posY;
        this.image = new PositionedImage(file, posX * tileSize, posY * tileSize);
        this.level = 1;
        this.maxHP = 2 * gameLevel * rollDice() + rollDice();
        this.HP = maxHP;
        this.DP = gameLevel / 2 * rollDice() + rollDice() / 2;
        this.SP = gameLevel * rollDice() + gameLevel;
    }
}