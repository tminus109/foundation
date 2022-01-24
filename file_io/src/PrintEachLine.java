import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) {
        String source = "assets/my_file.txt";
        List<String> file = readSource(source);
        printEachLine(file);
    }

    public static List<String> readSource(String source) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            System.out.println("Unable to read file: " + source);
        }
        return file;
    }

    public static void printEachLine(List<String> file) {
        for (String s : file) {
            System.out.println(s);
        }
    }
}
