package sprites;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters extends Sprite {
    List<Monster> monsterList;
    int monsterCount;
    List<Integer> startPos;

    public Monsters(List<int[]> floorTiles, int tileSize, int gameLevel) {
        this.monsterList = new ArrayList<>();
        this.monsterCount = 1 + 3;
        this.startPos = getStartPos(floorTiles);
        initMonsters(floorTiles, tileSize, gameLevel);
    }

    public List<Integer> getStartPos(List<int[]> floorTiles) {
        List<Integer> startPos = new ArrayList<>();
        startPos.add(0);
        for (int i = 0; i < monsterCount; i++) {
            int nextPos = random.nextInt(floorTiles.size());
            if (!startPos.contains(nextPos)) {
                startPos.add(nextPos);
            } else {
                i--;
            }
        }
        return startPos;
    }

    public void initMonsters(List<int[]> floorTiles, int tileSize, int gameLevel) {
        Boss boss = new Boss(floorTiles.get(startPos.get(1)), tileSize, gameLevel);
        monsterList.add(boss);
        for (int i = 2; i < startPos.size(); i++) {
            Skeleton skeleton = new Skeleton(floorTiles.get(startPos.get(i)), tileSize, gameLevel);
            monsterList.add(skeleton);
        }
        monsterList.get(2).setHasKey(true);
    }

    public void drawMonsters(Graphics graphics) {
        for (Monster monster : monsterList) {
            monster.drawSprite(graphics);
        }
    }

    public void animateMonsters(boolean[][] maze, int gridSize, int tileSize) {
        for (Monster monster : monsterList) {
            monster.move(monster.findNextMove(), maze, gridSize, tileSize);
        }
    }

    public int getMonsterCount() {
        return monsterList.size();
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
