package map;

import sprites.Monster;
import utilities.Grid;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Map implements Grid {
    boolean[][] maze;
    List<int[]> floorTiles;
    HashMap<Monster, int[]> tilesOccupiedByMonster;

    public Map() {
        this.maze = buildMap();
        this.floorTiles = getFloorTiles();
        this.tilesOccupiedByMonster = new HashMap<>();
    }

    boolean[][] createMapAllFloorTiles() {
        boolean[][] map = new boolean[grid][grid];
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                map[i][j] = true;
            }
        }
        return map;
    }

    int wallCount() {
        Random random = new Random();
        return random.nextInt(80 - 40) + 40;
    }

    int directionOfNewWall() {
        Random random = new Random();
        return random.nextInt(4);
    }

    int lengthOfNewWall() {
        Random random = new Random();
        return random.nextInt(grid);
    }

    boolean[][] buildMap() {
        boolean[][] map = createMapAllFloorTiles();
        int x = 0;
        int y = 0;
        int wallCount = wallCount();
        for (int i = 0; i < wallCount; i++) {
            int direction = directionOfNewWall();
            for (int j = 0; j < lengthOfNewWall(); j++) {
                if (direction == 0 && x < grid - 1) {
                    x++;
                } else if (direction == 1 && y < grid - 1) {
                    y++;
                } else if (direction == 2 && x > 0) {
                    x--;
                } else if (direction == 3 && y > 0) {
                    y--;
                }
                map[x][y] = false;
            }
        }
        return map;
    }

    public void drawMap(Graphics graphics) {
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                Tile tile = new Tile(maze[i][j], i * Grid.tile, j * Grid.tile);
                tile.drawTile(graphics);
            }
        }
    }

    public List<int[]> getFloorTiles() {
        List<int[]> floorTiles = new ArrayList<>();
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                if (!maze[i][j]) {
                    int[] posXY = new int[]{i, j};
                    floorTiles.add(posXY);
                }
            }
        }
        return floorTiles;
    }

    public boolean[][] getMaze() {
        return maze;
    }

    public boolean isOutOfBounds(int posX, int posY) {
        return posX < 0 || posX >= grid || posY < 0 || posY >= grid;
    }

    public boolean isWall(int posX, int posY) {
        return !maze[posX][posY];
    }

    public boolean isTileOnFloor(int posX, int posY) {
        return !isOutOfBounds(posX, posY) && isWall(posX, posY);
    }

    public void setMaze(boolean[][] maze) {
        this.maze = maze;
    }

    public void setFloorTiles(List<int[]> floorTiles) {
        this.floorTiles = floorTiles;
    }

    public HashMap<Monster, int[]> getTilesOccupiedByMonster() {
        return tilesOccupiedByMonster;
    }

    public void setTileOccupiedByMonster(Monster monster, int[] tile) {
        this.tilesOccupiedByMonster.put(monster, tile);
    }

    public boolean isTileOccupiedByMonster(int[] newPos) {
        for (HashMap.Entry<Monster, int[]> monster : tilesOccupiedByMonster.entrySet()) {
            if (Arrays.equals(monster.getValue(), newPos)) {
                return false;
            }
        }
        return true;
    }

    //    public void printMap() {
//        for (HashMap.Entry<Monster, int[]> m : tilesOccupiedByMonster.entrySet()) {
//            int[] a = m.getValue();
//            System.out.println(m.getKey() + " " + Arrays.toString(a));
//        }
//        System.out.println();
//    }
}
