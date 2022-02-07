package app;

import map.Map;
import sprites.Hero;
import sprites.Monster;
import sprites.Monsters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends JComponent implements KeyListener {
    int gridSize, tileSize, gameLevel, maxLevel;
    Map map;
    List<int[]> floorTiles;
    Hero hero;
    Monsters monsters;

    public Board() {
        setPreferredSize(new Dimension(720, 1000));
        this.gridSize = 10;
        this.tileSize = 72;
        this.gameLevel = 1;
        this.maxLevel = 3;
        this.map = new Map(gridSize, tileSize);
        this.floorTiles = map.floorTiles;
        this.hero = new Hero(map.floorTiles.get(0), tileSize);
        this.monsters = new Monsters(floorTiles, tileSize, gameLevel);
        scheduleMonsterAnimation();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        map.drawMap(graphics, gridSize, tileSize);
        hero.drawSprite(graphics);
        monsters.drawMonsters(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.move("up", map.maze, gridSize, tileSize);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.move("down", map.maze, gridSize, tileSize);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.move("left", map.maze, gridSize, tileSize);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.move("right", map.maze, gridSize, tileSize);
        }
        repaint(hero.getSavedX() * tileSize, hero.getSavedY() * tileSize, tileSize, tileSize);
        repaint(hero.getPosX() * tileSize, hero.getPosY() * tileSize, tileSize, tileSize);
    }

    public void scheduleMonsterAnimation() {
        TimerTask animateMonsters = new TimerTask() {
            public void run() {
                monsters.animateMonsters(map.maze, gridSize, tileSize);
                for (int i = 0; i < monsters.getMonsterCount(); i++) {
                    Monster monster = monsters.getMonsterList().get(i);
                    repaint(monster.getSavedX() * tileSize, monster.getSavedY() * tileSize, tileSize, tileSize);
                    repaint(monster.getPosX() * tileSize, monster.getPosY() * tileSize, tileSize, tileSize);
                }
            }
        };
        java.util.Timer timer = new Timer("Timer");
        long delay = 3000;
        long period = 3000L;
        timer.scheduleAtFixedRate(animateMonsters, delay, period);
    }
}
