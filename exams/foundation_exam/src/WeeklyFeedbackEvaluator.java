import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeeklyFeedbackEvaluator {
    public static void main(String[] args) {
        String source = "assets/responses.txt";
        List<String> file = readFile(source);
        HashMap<String, Float> averageRatings = getAverageRatings(file);
        System.out.println(averageRatings);
    }

    static List<String> readFile(String source) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    static HashMap<String, Float> getAverageRatings(List<String> file) {
        HashMap<String, Float> averageRatings = new HashMap<>();
        float m = 0, p = 0, h = 0, e = 0;
        for (String nextLine : file) {
            String[] ratings = nextLine.split(" ");
            for (int j = 0; j < ratings.length; j++) {
                if (j == 0) {
                    m += Float.parseFloat(ratings[j]);
                } else if (j == 1) {
                    p += Float.parseFloat(ratings[j]);
                } else if (j == 2) {
                    h += Float.parseFloat(ratings[j]);
                } else {
                    e += Float.parseFloat(ratings[j]);
                }
            }
            averageRatings.put("matReview", m / ratings.length);
            averageRatings.put("presSkills", p / ratings.length);
            averageRatings.put("helpfulness", h / ratings.length);
            averageRatings.put("explanations", e / ratings.length);
        }
        return averageRatings;
    }
}
