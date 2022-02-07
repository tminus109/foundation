package map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    public boolean[][] maze;
    public List<int[]> floorTiles;
    int wallCount, length, direction;
    Random random;

    public Map(int gridSize, int tileSize) {
        this.maze = buildMap(gridSize);
        this.floorTiles = getFloorTiles(gridSize, tileSize);
    }

    boolean[][] createMapAllFloorTiles(int gridSize) {
        boolean[][] map = new boolean[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
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

    int lengthOfNewWall(int gridSize) {
        random = new Random();
        return random.nextInt(gridSize);
    }

    boolean[][] buildMap(int gridSize) {
        boolean[][] map = createMapAllFloorTiles(gridSize);
        int x = 0;
        int y = 0;
        wallCount = wallCount();
        for (int i = 0; i < wallCount(); i++) {
            length = lengthOfNewWall(gridSize);
            direction = directionOfNewWall();
            for (int j = 0; j < length; j++) {
                if (direction == 0 && x < gridSize - 1) {
                    x++;
                } else if (direction == 1 && y < gridSize - 1) {
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

    public void drawMap(Graphics graphics, int gridSize, int tileSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Tile tile = new Tile(maze[i][j], i * tileSize, j * tileSize);
                tile.drawTile(graphics);
            }
        }
    }

    public List<int[]> getFloorTiles(int gridSize, int tileSize) {
        List<int[]> floorTiles = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (!maze[i][j]) {
                    int[] posXY = new int[]{i, j};
                    floorTiles.add(posXY);
                }
            }
        }
        return floorTiles;
    }
}
