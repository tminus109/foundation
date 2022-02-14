package scoreboard;

import sprites.*;
import utilities.Grid;

import java.awt.*;

public class Scoreboard implements Grid {
    String message;

    public Scoreboard() {
        this.message = """
                Hello Wanderer,
                Find the key and defeat the Boss to get to the next level.
                Attack a monster by trying to run over it.
                Careful, monsters can attack you, too!""";
    }

    public void drawMessage(Graphics graphics) {
        graphics.setFont(graphics.getFont().deriveFont(20f));
        int lineHeight = graphics.getFontMetrics().getHeight();
        int stringWidth = 0;
        int posX = 0;
        int posY = (grid * tile) + (scoreboardHeight - calculateLineCount() * lineHeight) / 2;
        for (String line : message.split("\n")) {
            stringWidth = graphics.getFontMetrics().stringWidth(line);
            posX = (width - stringWidth) / 2;
            graphics.drawString(line, posX, posY += lineHeight);
        }
    }

    public int calculateLineCount() {
        int lineCount = 0;
        for (String ignored : message.split("\n")) {
            lineCount++;
        }
        return lineCount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVictoryMessage(Sprite winner, boolean isBossDead) {
        if (winner instanceof Hero) {
            if (winner.hasKey() && isBossDead) {
                setMessage("""
                        VICTORY!

                        You have found the key and defeated the Boss.
                        Press RETURN to move to the next level.""");
            } else if (winner.hasKey() && !isBossDead) {
                setMessage("""
                        You've won!
                        You have found the key but you still need to defeat the Boss.""");
            } else if (!winner.hasKey() && !isBossDead) {
                setMessage("""
                        You've won!
                        But the Boss is still alive and you haven't found the key yet.
                        Where could it be?""");
            } else if (!winner.hasKey() && isBossDead) {
                setMessage("""
                        You've won!
                        The Boss is dead already but you haven't found the key yet.
                        Where could it be?""");
            }
        } else if (winner instanceof Boss || winner instanceof Skeleton) {
            setMessage("""
                    This monster was stronger than you and I'm afraid you died.
                    Better luck next time.

                    GAME OVER!""");
        }
    }
}
