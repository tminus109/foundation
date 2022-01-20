import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void drawImage(Graphics graphics) {
        int increment = 20;
        int iterator = WIDTH / increment;

        for (int i = 0; i < iterator; i++) {
            drawLines(graphics, i * increment, i * increment, increment);
        }
    }

    public static void drawLines(Graphics graphics, int x1, int y1, int increment) {
        graphics.drawLine(x1, 0, WIDTH / 2, HEIGHT / 2);
        graphics.drawLine(WIDTH, y1, WIDTH / 2, HEIGHT / 2);
        graphics.drawLine(x1 + increment, HEIGHT, WIDTH / 2, HEIGHT / 2);
        graphics.drawLine(0, y1 + increment, WIDTH / 2, HEIGHT / 2);
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
