package sprites;

public abstract class Monster extends Sprite {
    String[] directions = {"left", "right", "up", "down"};

    public String findNextMove() {
        int nextMove = random.nextInt(4);
        return directions[nextMove];
    }
}
