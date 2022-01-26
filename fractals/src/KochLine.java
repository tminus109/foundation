import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochLine {
    public static void drawImage(Graphics graphics) {
        double length = WIDTH * 0.9;
        double x1 = (WIDTH - length) / 2;
        double y1 = HEIGHT / 2;
        double x5 = x1 + length;
        int recursion = 4;

        drawFractal(x1, y1, x5, y1, recursion, graphics);
    }

    public static void drawFractal(double x1, double y1, double x5, double y5, int recursion, Graphics graphics) {
        if (recursion == 0) {
            graphics.drawLine((int) x1, (int) y1, (int) x5, (int) y5);
        } else {
            double X1, Y1, X2, Y2, X3, Y3, X4, Y4;

            X1 = x5 - x1;
            Y1 = y5 - y1;

            X2 = x1 + X1 / 3;
            Y2 = y1 + Y1 / 3;

            X3 = (int) (((x1 + x5) / 2) + Math.sqrt(3) * (y1 - y5) / 6);
            Y3 = (int) (((y1 + y5) / 2) + Math.sqrt(3) * (x5 - x1) / 6);

            X4 = x1 + 2 * X1 / 3;
            Y4 = y1 + 2 * Y1 / 3;

            drawFractal(x1, y1, X2, Y2, recursion - 1, graphics);
            drawFractal(X2, Y2, X3, Y3, recursion - 1, graphics);
            drawFractal(X3, Y3, X4, Y4, recursion - 1, graphics);
            drawFractal(X4, Y4, x5, y5, recursion - 1, graphics);
        }
    }

    static int WIDTH = 1000;
    static int HEIGHT = 1000;

    public static void main(String[] args) {
        JFrame f = new JFrame("Koch Line");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        KochLine.ImagePanel p = new KochLine.ImagePanel();
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
