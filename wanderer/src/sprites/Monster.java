package sprites;

import java.util.Random;

public abstract class Monster extends Sprite {
    public String computeNextRandomDirection() {
        String[] directions = {"left", "right", "up", "down"};
        Random random = new Random();
        int direction = random.nextInt(4);
        return directions[direction];
    }
}
