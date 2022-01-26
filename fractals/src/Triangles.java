import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void drawImage(Graphics graphics) {
        double length = WIDTH * 0.9;
        double radius = (Math.sqrt(3) / 2) * length;   // (√3 / 2) * length
        double x = (WIDTH - length) / 2;
        double y = (HEIGHT - radius) / 2;
        int recursion = 6;

        drawFractal(x, y, length, radius, recursion, graphics);
    }

    public static void drawFractal(double x, double y, double length, double radius, int recursion, Graphics graphics) {
        drawTriangle(x, y, length, radius, graphics);

        if (recursion > 0) {
            double l = length / 2;
            double r = radius / 2;

            drawFractal(x + l, y, l, r, recursion - 1, graphics);
            drawFractal(x, y, l, r, recursion - 1, graphics);
            drawFractal(x + l / 2, y + r, l, r, recursion - 1, graphics);
        }
    }

    public static void drawTriangle(double x, double y, double length, double radius, Graphics graphics) {
        Random rgb = new Random();

        int r = rgb.nextInt(256);
        int g = rgb.nextInt(256);
        int b = rgb.nextInt(256);

        graphics.setColor(new Color(r, g, b));

        int[] xPoints = {(int) x, (int) (x + length), (int) (x + (length / 2)), (int) x};
        int[] yPoints = {(int) y, (int) y, (int) (y + radius), (int) y};
        int nPoints = 4;

        graphics.drawPolygon(xPoints, yPoints, nPoints);
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Triangles");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Triangles.ImagePanel p = new Triangles.ImagePanel();
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.add(p);
        f.setVisible(true);
        f.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}
