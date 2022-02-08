package app;

import javax.swing.*;

public class Wanderer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wanderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        Board board = new Board(game);
        frame.addKeyListener(board);
        frame.setVisible(true);
        frame.add(board);
        frame.pack();
    }
}
