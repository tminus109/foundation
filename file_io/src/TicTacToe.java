import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    public static void main(String[] args) {
        String o = "assets/win_o.txt";
        String x = "assets/win_x.txt";
        String draw = "assets/draw.txt";
        List<String> fileO = readSource(o);
        List<String> fileX = readSource(x);
        List<String> fileDraw = readSource(draw);
        char[][] charsOfO = getChars(fileO);
        char[][] charsOfX = getChars(fileX);
        char[][] charsOfDraw = getChars(fileDraw);
        findWinner(charsOfO);
        findWinner(charsOfX);
        findWinner(charsOfDraw);
    }

    public static List<String> readSource(String source) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static char[][] getChars(List<String> file) {
        char[][] chars = new char[3][3];
        for (int i = 0; i < file.size(); i++) {
            String nextLine = file.get(i);
            for (int j = 0; j < nextLine.length(); j++) {
                chars[i][j] = nextLine.charAt(j);
            }
        }
        return chars;
    }

    private static void findWinner(char[][] chars) {
        String result = "It's a draw";
        for (char[] aChar : chars) {
            for (int j = 0; j < aChar.length; j++) {
                char O = 'O';
                char X = 'X';
                if ((aChar[0] == O && aChar[1] == O && aChar[2] == O) ||
                        (chars[0][j] == O && chars[1][j] == O && chars[2][j] == O) ||
                        (chars[0][0] == O && chars[1][1] == O && chars[2][2] == O) ||
                        (chars[2][0] == O && chars[1][1] == O && chars[0][2] == O)) {
                    result = "The winner is: " + O;
                } else if ((aChar[0] == X && aChar[1] == X && aChar[2] == X) ||
                        (chars[0][j] == X && chars[1][j] == X && chars[2][j] == X) ||
                        (chars[0][0] == X && chars[1][1] == X && chars[2][2] == X) ||
                        (chars[2][0] == X && chars[1][1] == X && chars[0][2] == X)) {
                    result = "The winner is: " + X;
                }
            }
        }
        System.out.println(result);
    }
}
