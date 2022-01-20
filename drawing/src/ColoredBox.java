import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void drawImage(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawLine(150, 150, 450, 150);
        graphics.setColor(Color.RED);
        graphics.drawLine(450, 150, 450, 450);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(450, 450, 150, 450);
        graphics.setColor(Color.MAGENTA);
        graphics.drawLine(150, 450, 150, 150);
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
