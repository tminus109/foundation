package sprites;

import app.Board;
import maze.Maze;
import scoreboard.Scoreboard;
import utilities.Grid;
import utilities.PositionedImage;

import java.awt.*;
import java.util.Random;

public abstract class Sprite implements Grid {
    String type, file, direction;
    PositionedImage image;
    int posX, posY, savedX, savedY, level, maxHP, HP, DP, SP;
    boolean isDead, isFighting, hasKey;

    public int rollDie() {
        Random random = new Random();
        return random.nextInt(7 - 1) + 1;
    }

    public void drawSprite(Graphics graphics) {
        image.draw(graphics);
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
                file = ((Hero) this).getFileMatchingDirection(direction);
            }
            if (maze.isTileFloorAndUnoccupied(nextPosX, nextPosY) && !isFighting) {
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
            setImage(file, posX, posY);
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
        Scoreboard scoreboard = board.getScoreboard();
        this.setFighting(true);
        sprite.setFighting(true);
        scoreboard.setMessage(this.type + " attacked " + sprite.type + "!\n" +
                this + "\n" +
                sprite + "\n" +
                "You can't run away from a fight.\n" +
                "Press SPACE to strike.\n");
        board.repaint(0, 721, width, scoreboardHeight);
    }

    public void strike(Sprite sprite, Board board) {
        Monsters monsters = board.getMonsters();
        Scoreboard scoreboard = board.getScoreboard();
        int SV = this.SP * rollDie() * 2;
        if (SV > sprite.DP) {
            sprite.HP = sprite.HP - (SV - sprite.DP);
            if (sprite.HP > 0) {
                sprite.strike(this, board);
            } else {
                this.isFighting = false;
                if (this instanceof Hero && sprite.hasKey) {
                    sprite.setKey(false);
                    this.setKey(true);
                }
                sprite.killOffSprite(board);
                scoreboard.setVictoryMessage(this, monsters.isBossDead());
                board.repaint(0, 721, width, scoreboardHeight);
            }
        } else if (SV < sprite.DP) {
            scoreboard.setMessage("You need to hit harder. Strike again.");
            board.repaint(0, 721, width, scoreboardHeight);
        }
    }

    public void killOffSprite(Board board) {
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

    @Override
    public String toString() {
        return type + ": L: " + level + " | HP: " + HP + "/" + maxHP
                + " | DP: " + DP + " | SP: " + SP;
    }

    public String getFile() {
        return file;
    }

    public void setImage(String file, int posX, int posY) {
        this.image = new PositionedImage(file, posX * tile, posY * tile);
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

    public boolean isFighting() {
        return isFighting;
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void setKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
}
