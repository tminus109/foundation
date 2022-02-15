package sprites;

import maze.Maze;
import utilities.Grid;
import utilities.PositionedImage;

import java.util.Random;

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
        this.maxHP = 20 + (3 * rollDie());
        this.HP = maxHP;
        this.DP = 2 * rollDie();
        this.SP = 5 + rollDie();
        maze.updateOccupiedTilesMap(this, posX, posY);
    }

    public String getFileMatchingDirection(String direction) {
        return switch (direction) {
            case "left" -> "assets/hero_left.png";
            case "right" -> "assets/hero_right.png";
            case "up" -> "assets/hero_up.png";
            default -> "assets/hero_down.png";
        };
    }

    public boolean isVictorious(Monsters monsters) {
        return hasKey && monsters.isBossDead();
    }

    private int restoreHP() {
        Random random = new Random();
        int restoredHP = 0;
        int chance = random.nextInt(10);
        if (chance == 0) {
            restoredHP = maxHP;
        } else if (chance < 5) {
            restoredHP = HP + HP / 3;
        } else {
            restoredHP = HP + HP / 10;
        }
        if (restoredHP > maxHP) {
            restoredHP = maxHP;
        }
        return restoredHP;
    }

    public void levelUp(Maze maze) {
        level++;
        int startPosX = maze.getFloorTiles().get(0)[0];
        int startPosY = maze.getFloorTiles().get(0)[1];
        setPosX(startPosX);
        setPosY(startPosY);
        setSavedX(startPosX);
        setSavedY(startPosY);
        maxHP += rollDie();
        DP += rollDie();
        SP += rollDie();
        HP = restoreHP();
        setKey(false);
        setImage("assets/hero_down.png", startPosX, startPosY);
        maze.updateOccupiedTilesMap(this, startPosX, startPosY);
    }
}
