package map;

import utilities.Grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements Grid {
    public boolean[][] maze;
    public List<int[]> floorTiles;
    int wallCount, length, direction;
    Random random;

    public Map() {
        this.maze = buildMap();
        this.floorTiles = getFloorTiles();
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
        random = new Random(40);
        return random.nextInt(80);
    }

    int directionOfNewWall() {
        random = new Random();
        return random.nextInt(4);
    }

    int lengthOfNewWall() {
        random = new Random();
        return random.nextInt(grid);
    }

    boolean[][] buildMap() {
        boolean[][] map = createMapAllFloorTiles();
        int x = 0;
        int y = 0;
        wallCount = wallCount();
        for (int i = 0; i < wallCount(); i++) {
            length = lengthOfNewWall();
            direction = directionOfNewWall();
            for (int j = 0; j < length; j++) {
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
}
