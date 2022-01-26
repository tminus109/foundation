import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Hexagon {
    public static void drawImage(Graphics graphics) {
        double length = (WIDTH / 2) - (Math.random() * 50);
        double radius = (Math.sqrt(3) / 2) * length;   // Same es equilateral triangle's height = (√3 / 2) * length
        double x = (WIDTH - length) / 2;
        double y = (HEIGHT - (radius * 2)) / 2;
        int recursion = 4;

        drawFractal(x, y, length, radius, recursion, graphics);
    }

    public static void drawFractal(double x, double y, double length, double radius, int recursion, Graphics graphics) {
        drawHexagon(x, y, length, radius, graphics);

        if (recursion > 0) {
            double l = length / 3;
            double r = radius / 3;

            drawFractal(x, y, l, r, recursion - 1, graphics);
            drawFractal(x + (l * 2), y, l, r, recursion - 1, graphics);
            drawFractal(x - l, y + (r * 2), l, r, recursion - 1, graphics);
            drawFractal(x, y + (r * 4), l, r, recursion - 1, graphics);
            drawFractal(x + (l * 2), y + (r * 4), l, r, recursion - 1, graphics);
            drawFractal(x + (l * 3), y + (r * 2), l, r, recursion - 1, graphics);
        }
    }

    public static void drawHexagon(double x, double y, double length, double radius, Graphics graphics) {
//        Random rgb = new Random();
//
//        int r = rgb.nextInt(256);
//        int g = rgb.nextInt(256);
//        int b = rgb.nextInt(256);
//
//        graphics.setColor(new Color(r, g, b));

        int[] xPoints = {(int) x, (int) (x + length), (int) x + (int) (length * 1.5), (int) (x + length), (int) x, (int) (x - length / 2), (int) x};
        int[] yPoints = {(int) y, (int) y, (int) (y + radius), (int) (y + radius * 2), (int) (y + radius * 2), (int) (y + radius), (int) y};
        int nPoints = 7;

        graphics.setColor(Color.WHITE);
        graphics.fillPolygon(xPoints, yPoints, nPoints);

        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(xPoints, yPoints, nPoints);
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Hexagon");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Hexagon.ImagePanel p = new Hexagon.ImagePanel();
        p.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        p.setBackground(Color.LIGHT_GRAY);
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
