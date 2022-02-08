package app;

import map.Map;
import sprites.Hero;
import sprites.Monsters;
import utilities.Grid;

import java.awt.*;

public class Game implements Grid {
    int maxLevel, level;
    boolean isGameOn;
    Map map;
    Hero hero;
    Monsters monsters;

    public Game() {
        this.maxLevel = 3;
        this.level = 1;
        this.isGameOn = true;
        this.map = new Map();
        this.hero = new Hero(map.getFloorTiles().get(0));
        this.monsters = new Monsters(map, level);
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
        return isGameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.isGameOn = gameOn;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
