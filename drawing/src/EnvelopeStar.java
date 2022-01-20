import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void drawImage(Graphics graphics) {
        int increment = 20;
        int iterator = WIDTH / 2 / increment;

        for (int i = 0; i < iterator; i++) {
            drawLines(graphics, i * increment, i * increment);
        }
    }

    public static void drawLines(Graphics graphics, int x, int y) {
        graphics.setColor(Color.GREEN);
        graphics.drawLine(WIDTH / 2 - x, HEIGHT / 2, WIDTH / 2, y);
        graphics.drawLine(WIDTH / 2 + x, HEIGHT / 2, WIDTH / 2, y);
        graphics.drawLine(WIDTH / 2 - x, HEIGHT / 2, WIDTH / 2, HEIGHT - y);
        graphics.drawLine(WIDTH / 2 + x, HEIGHT / 2, WIDTH / 2, HEIGHT - y);
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
