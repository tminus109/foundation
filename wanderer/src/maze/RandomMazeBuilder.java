package maze;

import utilities.Grid;

import java.util.Random;

public class RandomMazeBuilder implements Grid {
    Random random;

    public RandomMazeBuilder() {
        this.random = new Random();
    }

    boolean[][] createMazeAllFloorTiles() {
        boolean[][] maze = new boolean[grid][grid];
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                maze[i][j] = true;
            }
        }
        return maze;
    }

    int calculateRandomWallCount() {
        return random.nextInt(80 - 40) + 40;
    }

    int calculateRandomDirectionOfNewWall() {
        return random.nextInt(4);
    }

    int calculateRandomLengthOfNewWall() {
        return random.nextInt(grid);
    }

    boolean[][] buildMaze() {
        boolean[][] maze = createMazeAllFloorTiles();
        int x = 0;
        int y = 0;
        int wallCount = calculateRandomWallCount();
        for (int i = 0; i < wallCount; i++) {
            int direction = calculateRandomDirectionOfNewWall();
            for (int j = 0; j < calculateRandomLengthOfNewWall(); j++) {
                if (direction == 0 && x < grid - 1) {
                    x++;
                } else if (direction == 1 && y < grid - 1) {
                    y++;
                } else if (direction == 2 && x > 0) {
                    x--;
                } else if (direction == 3 && y > 0) {
                    y--;
                }
                maze[x][y] = false;
            }
        }
        return maze;
    }
}
