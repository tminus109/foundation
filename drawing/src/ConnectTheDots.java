import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void drawImage(Graphics graphics) {
        int[][] box = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};
        int[][] shape = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
                {120, 100}, {85, 130}, {50, 100}};

        drawPolygon(graphics, box);
        drawPolygon(graphics, shape);
    }

    public static void drawPolygon(Graphics graphics, int[][] xYPoints) {
        graphics.setColor(Color.GREEN);

//        for (int i = 0; i < xYPoints.length - 1; i++) {
//            graphics.drawLine(xYPoints[i][0], xYPoints[i][1],
//                    xYPoints[i + 1][0], xYPoints[i + 1][1]);
//        }

        int[] xPoints = new int[xYPoints.length];
        int[] yPoints = new int[xYPoints.length];

        for (int i = 0; i < xYPoints.length; i++) {
            xPoints[i] = xYPoints[i][0];
            yPoints[i] = xYPoints[i][1];
        }

        graphics.drawPolygon(xPoints, yPoints, xYPoints.length);
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
