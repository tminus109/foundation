import java.util.ArrayList;
import java.util.List;

public class StreetFighter2 {
    public static List<String> getCharacters(String[][] fighters, String[] moves) {
        List<String> characters = new ArrayList<>();
        int horizontalPosition = 0;
        int verticalPosition = 0;

        for (String move : moves) {
            if (move.equals("left")) {
                if (horizontalPosition == 0) {
                    horizontalPosition = 5;
                } else {
                    horizontalPosition--;
                }
            } else if (move.equals("right")) {
                if (horizontalPosition == 5) {
                    horizontalPosition = 0;
                } else {
                    horizontalPosition++;
                }
            } else if (move.equals("up") && verticalPosition == 1) {
                verticalPosition = 0;
            } else if (move.equals("down") && verticalPosition == 0)
                verticalPosition = 1;
            characters.add(fighters[verticalPosition][horizontalPosition]);
        }

        return characters;
    }

    public static void main(String[] args) {
        String[][] fighters = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };
        String[] moves0 = {"up", "left", "right", "left", "left"};
        String[] moves1 = {"right", "down", "left", "left", "left", "left", "right"};

        System.out.println(getCharacters(fighters, moves0));
        System.out.println(getCharacters(fighters, moves1));
    }
}
