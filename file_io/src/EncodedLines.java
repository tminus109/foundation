import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {
    public static void main(String[] args) {
        String source = "assets/encoded_lines.txt";
        String target = "assets/encoded_lines_decoded.txt";
        List<String> file = readSource(source);
        List<String> decryptedFile = decryptFile(file);
        writeFile(decryptedFile, target);
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

    public static List<String> decryptFile(List<String> file) {
        List<String> decryptedFile = new ArrayList<>();
        for (String nextLine : file) {
            StringBuilder decryptedLine = new StringBuilder();
            for (int j = 0; j < nextLine.length(); j++) {
                int ascii = nextLine.charAt(j);
                if (ascii != 32) {
                    ascii--;
                }
                decryptedLine.append((char) ascii);
            }
            decryptedFile.add(decryptedLine.toString());
        }
        return decryptedFile;
    }

    public static void writeFile(List<String> file, String target) {
        try {
            Files.write(Path.of(target), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
