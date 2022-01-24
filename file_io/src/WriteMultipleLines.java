import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteMultipleLines {
    public static void main(String[] args) {
        String target = "assets/write_multiple_lines.txt";
        String text = "apple";
        int n = 5;
        writeMultipleLines(target, text, n);
    }

    public static void writeMultipleLines(String target, String text, int n) {
        for (int i = 0; i < n; i++) {
            try {
                Files.writeString(Path.of(target), text + "\n", StandardOpenOption.APPEND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
