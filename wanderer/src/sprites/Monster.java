package sprites;

import java.util.Random;

public abstract class Monster extends Sprite {
    String[] directions = {"left", "right", "up", "down"};

    public String computeNextRandomDirection() {
        Random random = new Random();
        int direction = random.nextInt(4);
        return directions[direction];
    }
}

//
//    public void move(String newDirection, Maze maze, Hero hero) {
//        setSavedX(posX);
//        setSavedY(posY);
//        switch (newDirection) {
//            case "left" -> {
//                if (hero.canBeAttacked(posX - 1, posY)) {
//                    attack(hero);
//                } else if (maze.isTileOnFloor(posX - 1, posY)
//                        && !hero.occupiesTile(posX - 1, posY)
//                        && !maze.isTileOccupiedByMonster(new int[]{posX - 1, posY})) {
//                    posX--;
//                }
//            }
//            case "right" -> {
//                if (hero.canBeAttacked(posX + 1, posY)) {
//                    attack(hero);
//                } else if (maze.isTileOnFloor(posX + 1, posY)
//                        && !hero.occupiesTile(posX + 1, posY)
//                        && !maze.isTileOccupiedByMonster(new int[]{posX + 1, posY})) {
//                    posX++;
//                }
//            }
//            case "up" -> {
//                if (hero.canBeAttacked(posX, posY - 1)) {
//                    attack(hero);
//                } else if (maze.isTileOnFloor(posX, posY - 1)
//                        && !hero.occupiesTile(posX, posY - 1)
//                        && !maze.isTileOccupiedByMonster(new int[]{posX, posY - 1})) {
//                    posY--;
//                }
//            }
//            case "down" -> {
//                if (hero.canBeAttacked(posX, posY + 1)) {
//                    attack(hero);
//                } else if (maze.isTileOnFloor(posX, posY + 1)
//                        && !hero.occupiesTile(posX, posY + 1)
//                        && !maze.isTileOccupiedByMonster(new int[]{posX, posY + 1})) {
//                    posY++;
//                }
//            }
//        }
//        setImage(file, posX * tile, posY * tile);
//        maze.setTileOccupiedByMonster(this, new int[]{getPosX(), getPosY()});
//    }
//
//    public String[] getDirections() {
//        return directions;
//    }
//
//    public void setDirections(String[] directions) {
//        this.directions = directions;
//    }
//}
