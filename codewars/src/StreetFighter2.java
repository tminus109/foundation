import java.util.ArrayList;
import java.util.List;

public class StreetFighter2 {
    public static List<String> getHoveredCharacters(String[][] fighters, String[] moves) {
        List<String> hoveredCharacters = new ArrayList<>();
        int horPos = 0;
        int vertPos = 0;

        for (String move : moves) {
            if (move.equals("left")) {
                if (horPos == 0) {
                    horPos = 5;
                } else {
                    horPos--;
                }
            } else if (move.equals("right")) {
                if (horPos == 5) {
                    horPos = 0;
                } else {
                    horPos++;
                }
            } else if (move.equals("up") && vertPos == 1) {
                vertPos = 0;
            } else if (move.equals("down") && vertPos == 0) {
                vertPos = 1;
            }

            hoveredCharacters.add(fighters[vertPos][horPos]);
        }

        return hoveredCharacters;
    }

    public static void main(String[] args) {
        String[][] fighters = {
                {"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                {"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"}
        };
        String[] moves = {"up", "left", "right", "left", "left"};
        String[] moves2 = {"right", "down", "left", "left", "left", "left", "right"};

        System.out.println(getHoveredCharacters(fighters, moves));
        System.out.println(getHoveredCharacters(fighters, moves2));
    }
}
