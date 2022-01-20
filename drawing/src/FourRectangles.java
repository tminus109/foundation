import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void drawImage(Graphics graphics) {
        drawRectangle(graphics, 20, 20, 40, 60);
        drawRectangle(graphics, 120, 160, 100, 100);
        drawRectangle(graphics, 45, 33, 234, 27);
        drawRectangle(graphics, 60, 460, 500, 101);
    }

    public static void drawRectangle(Graphics graphics, int x, int y, int width, int height) {
        graphics.drawRect(x, y, width, height);
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
