package sprites;

import utilities.Grid;
import utilities.PositionedImage;

import java.awt.*;
import java.util.Random;

public abstract class Sprite implements Grid {
    String type, file, direction;
    PositionedImage image;
    int posX, posY, savedX, savedY, level, maxHP, HP, DP, SP;
    boolean isDead;
    boolean hasKey;
    boolean fighting;
    Random random = new Random();

    public boolean isFighting() {
        return fighting;
    }

    public void setFighting(boolean fighting) {
        this.fighting = fighting;
    }

    public int rollDice() {
        return random.nextInt(7 - 1) + 1;
    }

    public void drawSprite(Graphics graphics) {
        image.draw(graphics);
    }

    public void setImage(String filename, int posX, int posY) {
        this.image = new PositionedImage(filename, posX, posY);
    }

    public void attack(Sprite sprite) {
        System.out.println("You are under attack!");
        setFighting(true);
        sprite.setFighting(true);
        // call strike
        // stop moving
        // implement battle scene
    }

    public void strike() {
    }

    public void levelUp() {
        level++;
    }

    @Override
    public String toString() {
        return type + " (level " + level + ") HP: " + HP + "/" + maxHP
                + " | DP: " + DP + " | SP: " + SP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public PositionedImage getImage() {
        return image;
    }

    public void setImage(PositionedImage image) {
        this.image = image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSavedX() {
        return savedX;
    }

    public void setSavedX(int savedX) {
        this.savedX = savedX;
    }

    public int getSavedY() {
        return savedY;
    }

    public void setSavedY(int savedY) {
        this.savedY = savedY;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDP() {
        return DP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
}
