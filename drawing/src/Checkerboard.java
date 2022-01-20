import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void drawImage(Graphics graphics) {
        int num = 8;
        int size = 100;
        boolean white = true;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (white) {
                    graphics.setColor(Color.WHITE);
                } else {
                    graphics.setColor(Color.BLACK);
                }
                graphics.fillRect(i * size, j * 100, size, size);
                white = !white;
            }
            white = !white;
        }
    }

    static int WIDTH = 800;
    static int HEIGHT = 800;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}
