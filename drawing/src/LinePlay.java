import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void drawImage(Graphics graphics) {
        int lineCount = 16;
        int increment = WIDTH / lineCount;

        for (int i = 1; i < lineCount; i++) {
            drawLines(graphics, i * increment, i * increment);
        }
    }

    public static void drawLines(Graphics graphics, int x, int y) {
        graphics.setColor(Color.MAGENTA);
        graphics.drawLine(x, 5, WIDTH - 5, y);

        graphics.setColor(Color.GREEN);
        graphics.drawLine(5, y, x, HEIGHT - 5);
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
