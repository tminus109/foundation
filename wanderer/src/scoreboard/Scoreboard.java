package scoreboard;

import utilities.Grid;

import java.awt.*;

public class Scoreboard implements Grid {
    String message;

    public Scoreboard() {
        this.message = """
                Hello Wanderer,
                Find the key and defeat the Boss to get to the next level.
                Attack a monster by trying to run over it.
                Careful, monsters can attack you, too!
                Happy wandering!""";
    }

    public void drawMessage(Graphics graphics) {
        graphics.setFont(graphics.getFont().deriveFont(20f));
        int lineHeight = graphics.getFontMetrics().getHeight();
        int stringWidth = 0;
        int x = 0;
        int y = height - tile * 2;
        for (String line : message.split("\n")) {
            stringWidth = graphics.getFontMetrics().stringWidth(line);
            x = (width - stringWidth) / 2;
            graphics.drawString(line, x, y += lineHeight);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
