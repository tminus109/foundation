import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Lottery {
    public static void main(String[] args) {
        String source = "assets/lottery.csv";
        List<String> file = readSource(source);
        Map<Integer, Integer> useCountOfAllLotteryNumbers = getUseCountOfAllLotteryNumbers(file);
        List<Integer> useCountOfMostCommonLotteryNumbers = getUseCountOfMostCommonLotteryNumbers(useCountOfAllLotteryNumbers);
        List<Integer> mostCommonLotteryNumbers = getMostCommonLotteryNumbers(useCountOfMostCommonLotteryNumbers, useCountOfAllLotteryNumbers);
        System.out.println(mostCommonLotteryNumbers);
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

    public static Map<Integer, Integer> getUseCountOfAllLotteryNumbers(List<String> file) {
        Map<Integer, Integer> useCountOfAllLotteryNumbers = new HashMap<>();
        for (String nextLine : file) {
            String[] splitLine = nextLine.split(";");
            for (int i = 11; i < 16; i++) {
                int number = Integer.parseInt(splitLine[i]);
                if (useCountOfAllLotteryNumbers.containsKey(number)) {
                    int value = useCountOfAllLotteryNumbers.get(number) + 1;
                    useCountOfAllLotteryNumbers.replace(number, value);
                } else {
                    useCountOfAllLotteryNumbers.put(number, 1);
                }
            }
        }
        return useCountOfAllLotteryNumbers;
    }

    public static List<Integer> getUseCountOfMostCommonLotteryNumbers(Map<Integer, Integer> lotteryNumbers) {
        List<Integer> useCountOfMostCommonLotteryNumbers = new ArrayList<>();
        List<Integer> useCountOfAllLotteryNumbers = new ArrayList<>(lotteryNumbers.values());
        Collections.sort(useCountOfAllLotteryNumbers);
        Collections.reverse(useCountOfAllLotteryNumbers);
        for (int i = 0; i < 5; i++) {
            if (!useCountOfMostCommonLotteryNumbers.contains(useCountOfAllLotteryNumbers.get(i))) {
                useCountOfMostCommonLotteryNumbers.add(useCountOfAllLotteryNumbers.get(i));
            }
        }
        return useCountOfMostCommonLotteryNumbers;
    }

    public static List<Integer> getMostCommonLotteryNumbers(List<Integer> useCountOfMostCommonLotteryNumbers,
                                                            Map<Integer, Integer> useCountOfAllLotteryNumbers) {
        List<Integer> mostCommonLotteryNumbers = new ArrayList<>();
        for (Integer useCountOfMostCommonLotteryNumber : useCountOfMostCommonLotteryNumbers) {
            for (Map.Entry<Integer, Integer> entry : useCountOfAllLotteryNumbers.entrySet()) {
                if (Objects.equals(entry.getValue(), useCountOfMostCommonLotteryNumber)) {
                    mostCommonLotteryNumbers.add(entry.getKey());
                }
            }
            if (mostCommonLotteryNumbers.size() >= 5) {
                break;
            }
        }
        return mostCommonLotteryNumbers;
    }
}
