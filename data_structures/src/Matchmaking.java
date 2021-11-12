import java.util.ArrayList;
import java.util.Arrays;

public class Matchmaking {
    public static ArrayList<String> match(ArrayList<String> girls, ArrayList<String> boys) {
        ArrayList<String> girlsAndBoys = new ArrayList<>();
        int iterator = girls.size();
        if (girls.size() < boys.size()) {
            iterator = boys.size();
        }
        for (int i = 0; i < iterator; i++) {
            String match = "";
            if (i < girls.size() && i < boys.size()) {
                match = girls.get(i) + "-" + boys.get(i);
            } else if (i >= girls.size()) {
                match = boys.get(i);
            } else {
                match = girls.get(i);
            }
            girlsAndBoys.add(match);
        }
        return girlsAndBoys;
    }

    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
        ArrayList<String> boys = new ArrayList<>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));
        System.out.println(match(girls, boys));
    }
}
