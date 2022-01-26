import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {
    public static void drawImage(Graphics graphics) {
        double diameter = WIDTH * 0.9;
        double x = WIDTH / 2;
        double y = HEIGHT / 2;
        int recursion = 4;

        drawFractal(x, y, diameter, recursion, graphics);
    }

    public static void drawFractal(double x, double y, double diameter, int recursion, Graphics graphics) {
        drawOval(x, y, diameter, graphics);

        if (recursion > 0) {
            double d = diameter / 2;
            double m = Math.sqrt(3) / 2;

            drawFractal(x, y - (d / 2), d, recursion - 1, graphics);
            drawFractal(x + (d / 2 * m), y + (d / 4), d, recursion - 1, graphics);
            drawFractal(x - (d / 2 * m), y + (d / 4), d, recursion - 1, graphics);
        }
    }

    public static void drawOval(double x, double y, double diameter, Graphics graphics) {
        Random rgb = new Random();

        int r = rgb.nextInt(256);
        int g = rgb.nextInt(256);
        int b = rgb.nextInt(256);

        graphics.setColor(new Color(r, g, b));
        graphics.drawOval((int) (x - (diameter / 2)), (int) (y - (diameter / 2)), (int) diameter, (int) diameter);
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Circles");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Circles.ImagePanel p = new Circles.ImagePanel();
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
