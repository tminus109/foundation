package maze;

import sprites.Sprite;
import utilities.Grid;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Maze implements Grid {
    boolean[][] maze;
    List<int[]> floorTiles;
    HashMap<Sprite, int[]> occupiedTiles;

    public Maze(RandomMazeBuilder randomMazeBuilder) {
        this.maze = randomMazeBuilder.buildMaze();
        this.floorTiles = getFloorTiles();
        this.occupiedTiles = new HashMap<>();
    }

    public void drawMaze(Graphics graphics) {
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                Tile newTile = new Tile(maze[i][j], i * tile, j * tile);
                newTile.drawTile(graphics);
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

    public boolean isPositionOutOfBounds(int posX, int posY) {
        return posX < 0 || posX >= grid || posY < 0 || posY >= grid;
    }

    public boolean isTileWall(int posX, int posY) {
        return maze[posX][posY];
    }

    public boolean isTileOccupied(int posX, int posY) {
        int[] tile = new int[]{posX, posY};
        for (HashMap.Entry<Sprite, int[]> entry : occupiedTiles.entrySet()) {
            if (Arrays.equals(entry.getValue(), tile)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTileFloorAndAvailable(int posX, int posY) {
        return !isPositionOutOfBounds(posX, posY) && !isTileWall(posX, posY) &&
                !isTileOccupied(posX, posY);
    }

    public Sprite getSpriteOccupyingTile(int posX, int posY) {
        int[] tile = new int[]{posX, posY};
        for (HashMap.Entry<Sprite, int[]> entry : occupiedTiles.entrySet()) {
            if (Arrays.equals(entry.getValue(), tile)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateOccupiedTilesMap(Sprite sprite, int posX, int posY) {
        occupiedTiles.put(sprite, new int[]{posX, posY});
    }

    public void removeSpriteFromOccupiedTilesMap(Sprite sprite) {
        occupiedTiles.remove(sprite);
    }
}
