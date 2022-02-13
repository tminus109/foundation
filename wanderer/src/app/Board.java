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
    RandomMazeBuilder randomMazeBuilder;
    Maze maze;
    Hero hero;
    Monsters monsters;
    Scoreboard scoreboard;
    KeyHandler keyHandler;
    int level;

    public Board() {
        this.setPreferredSize(new Dimension(width, height));
        this.level = 1;
        this.randomMazeBuilder = new RandomMazeBuilder();
        this.maze = new Maze(randomMazeBuilder);
        this.hero = new Hero(maze);
        this.monsters = new Monsters(maze, level);
        monsters.animateMonsters(this);
        this.scoreboard = new Scoreboard();
        this.keyHandler = new KeyHandler(this);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        maze.drawMaze(graphics);
        hero.drawSprite(graphics);
        monsters.drawMonsters(graphics);
        scoreboard.drawMessage(graphics);
    }

    public Maze getMaze() {
        return maze;
    }

    public Monsters getMonsters() {
        return monsters;
    }

    public Hero getHero() {
        return hero;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
}
