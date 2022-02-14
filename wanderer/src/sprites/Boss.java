package sprites;

import utilities.PositionedImage;

public class Boss extends Monster {
    public Boss(int[] startPos, int gameLevel) {
        this.type = "Boss";
        this.file = "assets/boss.png";
        this.posX = startPos[0];
        this.posY = startPos[1];
        this.savedX = posX;
        this.savedY = posY;
        this.image = new PositionedImage(file, posX * tile, posY * tile);
        this.level = gameLevel;
        this.maxHP = 2 * gameLevel * rollDice() + rollDice();
        this.HP = maxHP;
        this.DP = gameLevel * rollDice() + rollDice() / 2;
        this.SP = gameLevel * rollDice() + gameLevel;
    }
}
