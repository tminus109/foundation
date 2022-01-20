import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    public static void drawImage(Graphics graphics) {
        int numberOfStars = 175;

        for (int i = 0; i < numberOfStars; i++) {
            int size = (int) (Math.random() * 5);
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);

            drawStars(graphics, size, r, g, b, x, y);
        }
    }

    public static void drawStars(Graphics graphics,
                                 int size, int r, int g, int b, int x, int y) {
        graphics.setColor(new Color(r, g, b));
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
            this.setBackground(Color.BLACK);
            drawImage(graphics);
        }
    }
}
