package app;

import sprites.Hero;
import sprites.Monsters;
import utilities.Grid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyHandler implements KeyListener, Grid {
    Board board;

    KeyHandler(Board board) {
        this.board = board;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Monsters monsters = board.getMonsters();
        Hero hero = board.getHero();
        String prevFile = hero.getFile();
        int prevX = hero.getPosX();
        int prevY = hero.getPosY();

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.move("up", board);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.move("down", board);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.move("left", board);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.move("right", board);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE && hero.isFighting()) {
            hero.strike(monsters.getFightingMonster(), board);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && hero.isVictorious(monsters) && !hero.isFighting()) {
            board.initNextLevel();
        }

        if (hero.getPosX() != prevX || hero.getPosY() != prevY ||
                !hero.getFile().equals(prevFile)) {
            board.repaint(hero.getSavedX() * tile, hero.getSavedY() * tile, tile, tile);
            board.repaint(hero.getPosX() * tile, hero.getPosY() * tile, tile, tile);
        }
    }
}
