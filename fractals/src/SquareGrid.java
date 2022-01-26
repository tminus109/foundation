import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {
    public static void drawImage(Graphics graphics) {
        double x = WIDTH / 2;
        double y = HEIGHT / 2;
        double width = (WIDTH / 2) * 0.95;
        int recursion = 3;

        drawFractal(x, y, width, recursion, graphics);
    }

    public static void drawFractal(double x, double y, double width, int recursion, Graphics graphics) {
        Graphics2D t = (Graphics2D) graphics;
        float thickness = (recursion * 4) + 2;
        t.setStroke(new BasicStroke(thickness));

        drawSquare(x, y, width, graphics);

        if (recursion > 0) {
            double w = width / 2;

            drawFractal(x - w, y - w, w, recursion - 1, graphics);
            drawFractal(x + w, y + w, w, recursion - 1, graphics);
            drawFractal(x - w, y + w, w, recursion - 1, graphics);
            drawFractal(x + w, y - w, w, recursion - 1, graphics);
        }
    }

    public static void drawSquare(double x, double y, double width, Graphics graphics) {
        Random rgb = new Random();

        int r = rgb.nextInt(256);
        int g = rgb.nextInt(256);
        int b = rgb.nextInt(256);

        graphics.setColor(new Color(r, g, b));
        graphics.drawRect((int) (x - (width / 2)), (int) (y - (width / 2)), (int) width, (int) width);
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Square Grid");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SquareGrid.ImagePanel p = new SquareGrid.ImagePanel();
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
