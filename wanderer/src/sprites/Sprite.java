package sprites;

import app.Board;
import maze.Maze;
import utilities.Grid;
import utilities.PositionedImage;

import java.awt.*;
import java.util.Random;

public abstract class Sprite implements Grid {
    String type, file, direction;
    PositionedImage image;
    int posX, posY, savedX, savedY, level, maxHP, HP, DP, SP;
    boolean isDead, isFighting, hasKey;

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(7 - 1) + 1;
    }

    public void drawSprite(Graphics graphics) {
        image.draw(graphics);
    }

    public void setImage(String file, int posX, int posY) {
        this.image = new PositionedImage(file, posX, posY);
    }

    public void move(String direction, Board board) {
        if (!isDead) {
            Maze maze = board.getMaze();
            int nextPosX = posX;
            int nextPosY = posY;
            switch (direction) {
                case "left" -> nextPosX--;
                case "right" -> nextPosX++;
                case "up" -> nextPosY--;
                case "down" -> nextPosY++;
            }
            if (this instanceof Hero && !file.equals(direction)) {
                file = ((Hero) this).getFileMatchingNewDirection(direction);
            }
            if (maze.isTileFloorAndAvailable(nextPosX, nextPosY)) {
                savedX = posX;
                savedY = posY;
                posX = nextPosX;
                posY = nextPosY;
                maze.updateOccupiedTilesMap(this, posX, posY);
            } else if (maze.isTileOccupied(nextPosX, nextPosY)) {
                Sprite sprite = maze.getSpriteOccupyingTile(nextPosX, nextPosY);
                if (canAttackOtherSprite(sprite)) {
                    attack(sprite, board);
                }
            }
            setImage(file, posX * tile, posY * tile);
        }
    }

    public boolean canAttackOtherSprite(Sprite sprite) {
        if (isDead || isFighting || sprite.isDead || sprite.isFighting) {
            return false;
        }
        return (!(this instanceof Boss) || !(sprite instanceof Skeleton)) &&
                (!(this instanceof Skeleton) ||
                        (!(sprite instanceof Skeleton) && !(sprite instanceof Boss)));
    }

    public void attack(Sprite sprite, Board board) {
        this.setFighting(true);
        sprite.setFighting(true);
        System.out.println(this.type + " attacked " + sprite.type);
        if (this instanceof Boss || this instanceof Skeleton) {
            strike(sprite, board);
        }
    }

    public void strike(Sprite sprite, Board board) {
        int SV = this.SP * rollDice() * 2;
        if (SV > sprite.DP) {
            sprite.HP = sprite.HP - (SV - sprite.DP);
            System.out.println(this.type + " struck " + sprite.type + " with a force of " + SV + " who's HP after strike = " + sprite.HP + " and maxHP = " + sprite.maxHP);
            if (sprite.HP > 0) {
                sprite.strike(this, board);
            } else {
                sprite.killOffSprite(board);
                this.isFighting = false;
                if (this instanceof Hero && sprite.hasKey){
                    sprite.setHasKey(false);
                    this.setHasKey(true);
                    System.out.println("Does hero have the key? " + this.hasKey);
                }
            }
        } else if (SV < sprite.DP) {
            System.out.println("You need to hit harder. Try again!");
        }
    }

    public void killOffSprite(Board board) {
        System.out.println(this.type + " is dead");
        isFighting = false;
        isDead = true;
        if (this instanceof Boss || this instanceof Skeleton) {
            Monsters monsters = board.getMonsters();
            monsters.removeMonsterFromMonsterList((Monster) this);
        }
        Maze maze = board.getMaze();
        maze.removeSpriteFromOccupiedTilesMap(this);
        setImage("assets/floor_tile.png", getPosX(), getPosY());
        board.repaint(getPosX() * tile, getPosY() * tile, tile, tile);
    }

    public void levelUp() {
        this.level++;
    }

    @Override
    public String toString() {
        return type + " (level " + level + ") HP: " + HP + "/" + maxHP
                + " | DP: " + DP + " | SP: " + SP;
    }

    public String getFile() {
        return file;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getSavedX() {
        return savedX;
    }

    public int getSavedY() {
        return savedY;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isFighting() {
        return isFighting;
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
}
