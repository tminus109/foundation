import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {
    public static void drawImage(Graphics graphics) {
        drawLine(graphics, 0, 0, WIDTH, HEIGHT);
        drawLine(graphics, WIDTH, 0, 0, HEIGHT);
    }

    public static void drawLine(Graphics graphics, int x1, int y1, int x2, int y2) {
        if (x1 == 0 && y1 == 0) {
            graphics.setColor(Color.GREEN);
        } else {
            graphics.setColor(Color.RED);
        }

        graphics.drawLine(x1, y1, x2, y2);
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
