package app;

import map.Map;
import sprites.Hero;
import sprites.Monster;
import sprites.Monsters;
import utilities.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends JComponent implements KeyListener, Grid {
    Game game;
    Map map;
    Hero hero;
    Monsters monsters;

    public Board(Game game) {
        this.game = game;
        this.map = game.getMap();
        this.hero = game.getHero();
        this.monsters = game.getMonsters();
        setPreferredSize(new Dimension(720, 1000));
        animateMonsters();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        game.drawGame(graphics);
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
            hero.move("up", map);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.move("down", map);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.move("left", map);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.move("right", map);
        }
        repaint(hero.getSavedX() * tile, hero.getSavedY() * tile, tile, tile);
        repaint(hero.getPosX() * tile, hero.getPosY() * tile, tile, tile);
    }

    public void animateMonsters() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                monsters.moveMonsters(map, hero);
                for (int i = 0; i < monsters.getMonsterCount(); i++) {
                    Monster monster = monsters.getMonsterList().get(i);
                    if (!monster.isFighting()) {
                        repaint(monster.getSavedX() * tile, monster.getSavedY() * tile, tile, tile);
                        repaint(monster.getPosX() * tile, monster.getPosY() * tile, tile, tile);
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 3000L, 3000L);
    }
}
