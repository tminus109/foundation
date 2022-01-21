import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
    public static void drawImage(Graphics graphics) {
        int divisions = 16;
        int rows = (int) Math.sqrt(divisions);
        int lineCount = 16;
        double pad = 4;
        double increment = (WIDTH - rows * pad * 2) / (rows * lineCount);
        int startingXPos = 0;
        int startingYPos = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 1; k < lineCount; k++) {
                    int x = (int) (k * increment);
                    int y = (int) (k * increment);

                    graphics.setColor(Color.MAGENTA);
                    graphics.drawLine(startingXPos + x, (int) (startingYPos + pad), (int) (startingXPos + WIDTH / rows - pad), startingYPos + y);

                    graphics.setColor(Color.GREEN);
                    graphics.drawLine((int) (startingXPos + pad), (int) (startingYPos + y + pad), startingXPos + x, (int) (startingYPos + HEIGHT / rows - pad));
                }
                startingXPos += WIDTH / rows;
            }
            startingXPos = 0;
            startingYPos += HEIGHT / rows;
        }
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
