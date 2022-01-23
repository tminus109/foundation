import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        String source = "assets/copy_file.txt";
        String target = "assets/copy_file_copy.txt";
        System.out.println(copyFile(source, target));
    }

    public static boolean copyFile(String source, String target) {
        try {
            List<String> file = Files.readAllLines(Path.of(source));
            Files.write(Path.of(target), file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
