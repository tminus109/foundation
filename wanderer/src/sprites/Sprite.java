package sprites;

import utilities.PositionedImage;

import java.awt.*;
import java.util.Random;

public abstract class Sprite {
    String type, file, direction;
    PositionedImage image;
    int posX, posY, savedX, savedY, level, maxHP, HP, DP, SP;
    boolean isDead = false;
    boolean hasKey = false;
    Random random = new Random();

    public int rollDice() {
        return random.nextInt(7);
    }

    public void drawSprite(Graphics graphics) {
        image.draw(graphics);
    }

    public void setImage(String filename, int posX, int posY) {
        this.image = new PositionedImage(filename, posX, posY);
    }

    public void move(String newDirection, boolean[][] maze, int gridSize, int tileSize) {
        setSavedX(posX);
        setSavedY(posY);
        switch (newDirection) {
            case "left" -> {
                if (posX - 1 >= 0 && !maze[posX - 1][posY]) {
                    posX--;
                }
            }
            case "right" -> {
                if (posX + 1 < gridSize && !maze[posX + 1][posY]) {
                    posX++;
                }
            }
            case "up" -> {
                if (posY - 1 >= 0 && !maze[posX][posY - 1]) {
                    posY--;
                }
            }
            case "down" -> {
                if (posY + 1 < gridSize && !maze[posX][posY + 1]) {
                    posY++;
                }
            }
        }
        setImage(file, posX * tileSize, posY * tileSize);
    }

    public void attack(Sprite sprite) {
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

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
}
