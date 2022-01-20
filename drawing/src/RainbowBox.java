import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBox {
    public static void drawImage(Graphics graphics) {
        List<Color> colors = new ArrayList<>(Arrays.asList(
                Color.red, Color.orange, Color.yellow, Color.green, Color.blue,
                new Color(75, 0, 130), new Color(238, 130, 238)));
        int size = WIDTH;
        int increment = WIDTH / colors.size();

        for (Color color : colors) {
            drawSquare(graphics, size, color);
            size = size - increment;
        }
    }

    public static void drawSquare(Graphics graphics, int size, Color color) {
        graphics.setColor(color);
        graphics.fillRect(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size, size);
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
