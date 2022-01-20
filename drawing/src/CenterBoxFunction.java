import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

    public static void drawImage(Graphics graphics) {
        int size0 = 100;
        graphics.drawRect((WIDTH / 2 - size0 / 2), (HEIGHT / 2 - size0 / 2), size0, size0);

        int size1 = 200;
        graphics.drawRect((WIDTH / 2 - size1 / 2), (HEIGHT / 2 - size1 / 2), size1, size1);

        int size2 = 300;
        graphics.drawRect((WIDTH / 2 - size2 / 2), (HEIGHT / 2 - size2 / 2), size2, size2);
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
