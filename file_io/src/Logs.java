import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        String source = "assets/log.txt";
        List<String> file = readSource(source);
        System.out.println(getUniqueIPs(file));
        System.out.println(getGetPostRatio(file));
    }

    public static List<String> readSource(String source) {
        List<String> file = new ArrayList<>();
        try {
            return Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static List<String> getUniqueIPs(List<String> file) {
        List<String> uniqueIPs = new ArrayList<>();
        for (String nextLine : file) {
            String[] splitLine = nextLine.split("   ");
            String IP = splitLine[1];
            if (!uniqueIPs.contains(IP)) {
                uniqueIPs.add(IP);
            }
        }
        return uniqueIPs;
    }

    public static String getGetPostRatio(List<String> file) {
        int getRequestsCount = 0;
        int postRequestsCount = 0;
        for (String nextLine : file) {
            String[] splitLine = nextLine.split("   ");
            String request = splitLine[2];
            if (request.equals("GET /")) {
                getRequestsCount++;
            } else if (request.equals("POST /")) {
                postRequestsCount++;
            }
        }
        return "The GET : POST request ratio is "
                + getRequestsCount + " : " + postRequestsCount + ".";
    }
}
