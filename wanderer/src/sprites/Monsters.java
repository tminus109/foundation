package sprites;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters extends Sprite {
    List<Monster> monsterList;
    int monsterCount;
    List<Integer> startPos;

    public Monsters(List<int[]> floorTiles, int gameLevel) {
        this.monsterList = new ArrayList<>();
        this.monsterCount = 1 + 3;
        this.startPos = getStartPos(floorTiles);
        initMonsters(floorTiles, gameLevel);
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

    public void initMonsters(List<int[]> floorTiles, int gameLevel) {
        Boss boss = new Boss(floorTiles.get(startPos.get(1)), gameLevel);
        monsterList.add(boss);
        for (int i = 2; i < startPos.size(); i++) {
            Skeleton skeleton = new Skeleton(floorTiles.get(startPos.get(i)), gameLevel);
            monsterList.add(skeleton);
        }
        monsterList.get(2).setHasKey(true);
    }

    public void drawMonsters(Graphics graphics) {
        for (Monster monster : monsterList) {
            monster.drawSprite(graphics);
        }
    }

    public void moveMonsters(boolean[][] maze, Hero hero) {
        for (Monster monster : monsterList) {
            if (!monster.isFighting()) {
                monster.move(monster.nextDirection(), maze, hero);
            }
        }
    }

    public int getMonsterCount() {
        return monsterList.size();
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
