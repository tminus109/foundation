import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3D {
    public static void drawImage(Graphics graphics) {
        int squares = 6;
        int x = 20;
        int y = 20;
        int size = 20;
        double increment = 1.5;

        for (int i = 0; i < squares; i++) {
            drawSquare(graphics, x, y, size);
            x += size;
            y += size;
            size *= increment;
        }
    }

    public static void drawSquare(Graphics graphics, int x, int y, int size) {
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(x, y, size, size);
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
