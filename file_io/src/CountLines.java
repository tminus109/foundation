import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountLines {
    public static void main(String[] args) {
        System.out.println(countLines("assets/births.csv"));
    }

    public static int countLines(String source) {
        try {
            return Files.readAllLines(Path.of(source)).size();
        } catch (IOException e) {
            return 0;
        }
    }
}
