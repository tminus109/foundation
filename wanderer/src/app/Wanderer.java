package app;

import javax.swing.*;

public class Wanderer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wanderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
        frame.setVisible(true);
        frame.add(board);
        frame.pack();
        frame.addKeyListener(board);
    }
}
