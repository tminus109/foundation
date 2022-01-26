import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskiCarpet {
    public static void drawImage(Graphics graphics) {
        double x = WIDTH / 2;
        double y = HEIGHT / 2;
        double width = (WIDTH / 3) * 0.95;
        int recursion = 4;

        drawFractal(x, y, width, recursion, graphics);
    }

    public static void drawFractal(double x, double y, double width, int recursion, Graphics graphics) {
        drawSquare(x, y, width, graphics);

        if (recursion > 0) {
            double w = width / 3;

            drawFractal(x - width, y, w, recursion - 1, graphics);
            drawFractal(x + width, y, w, recursion - 1, graphics);
            drawFractal(x, y + width, w, recursion - 1, graphics);
            drawFractal(x, y - width, w, recursion - 1, graphics);
            drawFractal(x - width, y - width, w, recursion - 1, graphics);
            drawFractal(x - width, y + width, w, recursion - 1, graphics);
            drawFractal(x + width, y - width, w, recursion - 1, graphics);
            drawFractal(x + width, y + width, w, recursion - 1, graphics);
        }
    }

    public static void drawSquare(double x, double y, double width, Graphics graphics) {
        Random rgb = new Random();

        int r = rgb.nextInt(256);
        int g = rgb.nextInt(256);
        int b = rgb.nextInt(256);

        graphics.setColor(new Color(r, g, b));
        graphics.fillRect((int) (x - (width / 2)), (int) (y - (width / 2)), (int) width, (int) width);
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Sierpinski Carpet");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SierpinskiCarpet.ImagePanel p = new SierpinskiCarpet.ImagePanel();
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
