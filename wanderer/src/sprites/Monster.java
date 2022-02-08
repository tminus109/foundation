package sprites;

public abstract class Monster extends Sprite {
    String[] directions = {"left", "right", "up", "down"};

    public String nextDirection() {
        int direction = random.nextInt(4);
        return directions[direction];
    }

    public void move(String newDirection, boolean[][] maze, Hero hero) {
        setSavedX(posX);
        setSavedY(posY);
        switch (newDirection) {
            case "left" -> {
                if (posX - 1 == hero.getPosX() && posY == hero.getPosY() && !hero.isFighting()) {
                    attack(hero);
                } else if (posX - 1 >= 0 && !maze[posX - 1][posY]) {
                    posX--;
                }
            }
            case "right" -> {
                if (posX + 1 == hero.getPosX() && posY == hero.getPosY() && !hero.isFighting()) {
                    attack(hero);
                } else if (posX + 1 < grid && !maze[posX + 1][posY]) {
                    posX++;
                }
            }
            case "up" -> {
                if (posX == hero.getPosX() && posY - 1 == hero.getPosY() && !hero.isFighting()) {
                    attack(hero);
                } else if (posY - 1 >= 0 && !maze[posX][posY - 1]) {
                    posY--;
                }
            }
            case "down" -> {
                if (posX == hero.getPosX() && posY == hero.getPosY() && !hero.isFighting()) {
                    attack(hero);
                } else if (posY + 1 < grid && !maze[posX][posY + 1]) {
                    posY++;
                }
            }
        }
        setImage(file, posX * tile, posY * tile);
    }
}
