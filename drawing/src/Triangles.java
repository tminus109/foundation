import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void drawImage(Graphics graphics) {
        double size = 21;
        double length = WIDTH / size;
        double height = length * (Math.cbrt(3) / 2);
        double x0 = 0;
        double x1 = x0;
        double y1 = (HEIGHT - height * size) / 2 + height * size;
        int n = 3;
        double triangles = size;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < triangles; j++) {
                int[] xPoints = {(int) x1, (int) (x1 + length), (int) (x1 + length / 2)};
                int[] yPoints = {(int) y1, (int) y1, (int) (y1 - height)};
                drawTriangle(graphics, xPoints, yPoints, n);
                x1 += length;
            }
            x0 += length / 2;
            x1 = x0;
            y1 -= height;
            triangles--;
        }
    }

    public static void drawTriangle(Graphics graphics, int[] xPoints, int[] yPoints, int n) {
        graphics.drawPolygon(xPoints, yPoints, n);
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
