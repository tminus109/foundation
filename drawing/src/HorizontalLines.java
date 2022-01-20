import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
    public static void drawImage(Graphics graphics) {
        int length = 50;

        for (int i = 0; i < 3; i++) {
            drawLine(graphics, randomPoint(), randomPoint(), length);
        }
    }

    public static void drawLine(Graphics graphics, int x1, int y1, int length) {
        graphics.drawLine(x1, y1, x1 + length, y1);
    }

    public static int randomPoint() {
        return (int) (Math.random() * ((WIDTH + 1) - 50));
    }

    static int WIDTH = 600;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
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
