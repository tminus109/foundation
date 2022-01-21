import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
    public static void drawImage(Graphics graphics) {
        double size = 7;
        double t = WIDTH / (size + 2) / 1.5;
        double r = (Math.sqrt(3) / 2) * t;
        double x1 = r * 1.5;
        double y0 = (HEIGHT - (size / 2 * r * 2 - r)) / 2;
        double y1 = y0;
        double hexagons = size / 2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < hexagons; j++) {
                int[] xPoints = {(int) x1, (int) (x1 + t / 2), (int) (x1 + t * 1.5), (int) (x1 + t * 2), (int) (x1 + t * 1.5), (int) (x1 + t / 2)};
                int[] yPoints = {(int) y1, (int) (y1 - r), (int) (y1 - r), (int) y1, (int) (y1 + r), (int) (y1 + r)};
                int n = 6;
                graphics.drawPolygon(xPoints, yPoints, n);
                y1 += r * 2;
            }
            x1 += t * 1.5;
            if (i < size / 2 - 1) {
                hexagons++;
                y0 -= r;
            } else {
                hexagons--;
                y0 += r;
            }
            y1 = y0;
        }
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
