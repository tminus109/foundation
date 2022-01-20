import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {
    public static void drawImage(Graphics graphics) {
        int size0 = 100;
        int size1 = 200;
        int size2 = 300;

        drawSquare(graphics, size0);
        drawSquare(graphics, size1);
        drawSquare(graphics, size2);
    }

    public static void drawSquare(Graphics graphics, int size) {
        graphics.drawRect((WIDTH / 2 - size / 2), (HEIGHT / 2 - size / 2), size, size);
    }

    static int WIDTH = 600;
    static int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
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
