import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void drawImage(Graphics graphics) {
        int size = 300;
        int x = WIDTH / 4;
        int y = HEIGHT / 4;

        graphics.setColor(Color.BLUE);
        graphics.drawLine(x, y, x + size, y);
        graphics.setColor(Color.RED);
        graphics.drawLine(x + size, y, x + size, y + size);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(x + size, y + size, x, y + size);
        graphics.setColor(Color.MAGENTA);
        graphics.drawLine(x, y + size, x, y);
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
