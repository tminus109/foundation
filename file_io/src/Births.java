import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Births {
    public static void main(String[] args) {
        String source = "assets/births.csv";
        List<String> file = readSource(source);
        List<String> years = getYears(file);
        List<String> yearsWithMostBirths = getYearsWithMostBirths(years);
        System.out.println(yearsWithMostBirths);
    }

    public static List<String> readSource(String source) {
        Path path = Paths.get(source);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<String> getYears(List<String> file) {
        List<String> years = new ArrayList<>();
        for (String nextLine : file) {
            String[] splitLine = nextLine.split(";");
            String date = splitLine[1];
            String[] splitDate = date.split("-");
            String year = splitDate[0];
            years.add(year);
        }
        return years;
    }

    public static List<String> getYearsWithMostBirths(List<String> years) {
        Map<String, Integer> birthCount = new HashMap<>();
        for (String year : years) {
            if (!birthCount.containsKey(year)) {
                birthCount.put(year, 1);
            } else {
                int value = birthCount.get(year) + 1;
                birthCount.replace(year, value);
            }
        }

        int mostBirthsInAYear = 0;
        for (Integer value : birthCount.values()) {
            if (value > mostBirthsInAYear) {
                mostBirthsInAYear = value;
            }
        }

        List<String> yearsWithMostBirths = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : birthCount.entrySet()) {
            if (entry.getValue() == mostBirthsInAYear) {
                yearsWithMostBirths.add(entry.getKey());
            }
        }

        return yearsWithMostBirths;
    }
}
