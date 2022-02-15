package app;

import maze.Maze;
import maze.RandomMazeBuilder;
import scoreboard.Scoreboard;
import sprites.Hero;
import sprites.Monsters;
import utilities.Grid;

import javax.swing.*;
import java.awt.*;

public class Board extends JComponent implements Grid {
    int level;
    RandomMazeBuilder randomMazeBuilder;
    Maze maze;
    Hero hero;
    Monsters monsters;
    Scoreboard scoreboard;
    KeyHandler keyHandler;

    Board() {
        this.setPreferredSize(new Dimension(width, height));
        this.level = 1;
        this.randomMazeBuilder = new RandomMazeBuilder();
        this.maze = new Maze(randomMazeBuilder);
        this.hero = new Hero(maze);
        this.monsters = new Monsters(maze, level);
        this.scoreboard = new Scoreboard();
        this.keyHandler = new KeyHandler(this);
        monsters.animateMonsters(this);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        maze.drawMaze(graphics);
        hero.drawSprite(graphics);
        monsters.drawMonsters(graphics);
        scoreboard.drawMessage(graphics);
    }

    void initNextLevel() {
        level++;
        maze = new Maze(randomMazeBuilder);
        hero.levelUp(maze);
        monsters.purgeMonsterList();
        monsters = new Monsters(maze, level);
        monsters.animateMonsters(this);
        scoreboard.setMessage("Congrats Wanderer, you've made it to level " + level + "!\n" +
                "But careful, these monsters are stronger than the ones before.\n" +
                "Keep wandering!");
        repaint();
    }

    public Maze getMaze() {
        return maze;
    }

    public Hero getHero() {
        return hero;
    }

    public Monsters getMonsters() {
        return monsters;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
}
