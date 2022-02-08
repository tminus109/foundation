package app;

import map.Map;
import sprites.Hero;
import sprites.Monsters;
import utilities.Grid;

import java.awt.*;
import java.util.List;

public class Game implements Grid {
    int maxLevel, level;
    boolean gameOn;
    Map map;
    List<int[]> floorTiles;
    Hero hero;
    Monsters monsters;

    public Game() {
        this.maxLevel = 3;
        this.level = 1;
        this.gameOn = true;
        this.map = new Map();
        this.floorTiles = map.floorTiles;
        this.hero = new Hero(map.floorTiles.get(0));
        this.monsters = new Monsters(floorTiles, level);
    }

    public void drawGame(Graphics graphics) {
        map.drawMap(graphics);
        hero.drawSprite(graphics);
        monsters.drawMonsters(graphics);
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<int[]> getFloorTiles() {
        return floorTiles;
    }

    public void setFloorTiles(List<int[]> floorTiles) {
        this.floorTiles = floorTiles;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monsters getMonsters() {
        return monsters;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }
}
