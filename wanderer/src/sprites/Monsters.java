package sprites;

import app.Board;
import maze.Maze;

import java.awt.*;
import java.util.*;
import java.util.List;


public class Monsters extends Sprite {
    int monsterCount;
    List<Monster> monsterList;

    public Monsters(Maze maze, int gameLevel) {
        this.monsterCount = 1 + 3;
        this.monsterList = new ArrayList<>();
        initMonsters(maze, gameLevel);
    }

    public List<Integer> computeSpawnPositions(List<int[]> floorTiles) {
        Random random = new Random();
        List<Integer> spawnPositions = new ArrayList<>();
        for (int i = 0; i < monsterCount; i++) {
            int nextPos = random.nextInt(floorTiles.size() - 1) + 1;
            if (!spawnPositions.contains(nextPos)) {
                spawnPositions.add(nextPos);
            } else {
                i--;
            }
        }
        return spawnPositions;
    }

    public void initMonsters(Maze maze, int gameLevel) {
        List<int[]> floorTiles = maze.getFloorTiles();
        List<Integer> spawnPositions = computeSpawnPositions(floorTiles);
        Boss boss = new Boss(floorTiles.get(spawnPositions.get(0)), gameLevel);
        maze.updateOccupiedTilesMap(boss, boss.getPosX(), boss.getPosY());
        monsterList.add(boss);
        for (int i = 1; i < monsterCount; i++) {
            Skeleton skeleton = new Skeleton(floorTiles.get(spawnPositions.get(i)), gameLevel);
            if (i == 1) {
                skeleton.setHasKey(true);
            }
            monsterList.add(skeleton);
            maze.updateOccupiedTilesMap(skeleton, skeleton.getPosX(), skeleton.getPosY());
        }
    }

    public void drawMonsters(Graphics graphics) {
        for (Monster monster : monsterList) {
            monster.drawSprite(graphics);
        }
    }

    public void removeMonsterFromMonsterList(Monster monster) {
        monsterList.remove(monster);
    }

    public Monster getFightingMonster() {
        for (int i = 0; i < monsterCount; i++) {
            if (monsterList.get(i).isFighting()) {
                return monsterList.get(i);
            }
        }
        return null;
    }

    public void animateMonsters(Board board) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < monsterList.size(); i++) {
                    Monster monster = monsterList.get(i);
                    if (!monster.isFighting()) {
                        int prevX = monster.getPosX();
                        int prevY = monster.getPosY();
                        monster.move(monster.computeNextRandomDirection(), board);
                        if (monster.getPosX() != prevX || monster.getPosY() != prevY) {
                            board.repaint(monster.getSavedX() * tile, monster.getSavedY() * tile, tile, tile);
                            board.repaint(monster.getPosX() * tile, monster.getPosY() * tile, tile, tile);
                        }
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);
    }
}
