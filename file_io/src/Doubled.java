import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Doubled {
    public static void main(String[] args) {
        String source = "assets/duplicated_chars.txt";
        String target = "assets/output.txt";
        List<String> file = readSource(source);
        List<String> decryptedFile = decryptFile(file);
        copyFile(decryptedFile, target);
    }

    public static List<String> readSource(String source) {
        try {
            return Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<String> decryptFile(List<String> file) {
        List<String> decryptedFile = new ArrayList<>();
        for (String nextLine : file) {
            StringBuilder decryptedLine = new StringBuilder();
            for (int j = 0; j < nextLine.length(); j += 2) {
                decryptedLine.append(nextLine.charAt(j));
            }
            decryptedFile.add(decryptedLine.toString());
        }
        return decryptedFile;
    }

    public static void copyFile(List<String> file, String target) {
        try {
            Files.write(Path.of(target), file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
