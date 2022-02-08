package sprites;

import map.Map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monsters extends Sprite {
    List<Monster> monsterList;
    int monsterCount;

    public Monsters(Map map, int gameLevel) {
        this.monsterList = new ArrayList<>();
        this.monsterCount = 1 + 3;
        initMonsters(map, gameLevel);
    }

    public List<Integer> spawnPositions(List<int[]> floorTiles) {
        Random random = new Random();
        List<Integer> spawnPositions = new ArrayList<>();
        spawnPositions.add(0);
        for (int i = 0; i < monsterCount; i++) {
            int nextPos = random.nextInt(floorTiles.size());
            if (!spawnPositions.contains(nextPos)) {
                spawnPositions.add(nextPos);
            } else {
                i--;
            }
        }
        return spawnPositions;
    }

    public void initMonsters(Map map, int gameLevel) {
        List<int[]> floorTiles = map.getFloorTiles();
        List<Integer> spawnPositions = spawnPositions(floorTiles);
        Boss boss = new Boss(floorTiles.get(spawnPositions.get(1)), gameLevel, 1);
        map.setTileOccupiedByMonster(boss, new int[]{boss.getPosX(), boss.getPosY()});
        monsterList.add(boss);
        for (int i = 2; i < spawnPositions.size(); i++) {
            Skeleton skeleton = new Skeleton(floorTiles.get(spawnPositions.get(i)), gameLevel, i);
            monsterList.add(skeleton);
            map.setTileOccupiedByMonster(skeleton, new int[]{skeleton.getPosX(), skeleton.getPosY()});
        }
        monsterList.get(2).setHasKey(true);
    }

    public void drawMonsters(Graphics graphics) {
        for (Monster monster : monsterList) {
            monster.drawSprite(graphics);
        }
    }

    public void moveMonsters(Map map, Hero hero) {
        for (Monster monster : monsterList) {
            if (!monster.isFighting()) {
                monster.move(monster.nextDirection(), map, hero);
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
