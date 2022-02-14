package sprites;

import java.util.Random;

public abstract class Monster extends Sprite {
    String[] directions = {"left", "right", "up", "down"};

    public String computeNextRandomDirection() {
        Random random = new Random();
        int direction = random.nextInt(4);
        return directions[direction];
    }
}
