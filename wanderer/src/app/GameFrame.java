package app;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame(Board board) {
        this.add(board);
        this.addKeyListener(board.getKeyHandler());
        this.setTitle("Wanderer Game");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
}
