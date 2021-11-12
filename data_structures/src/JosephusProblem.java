import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static int whoRemains(int input) {
        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            players.add(i + 1);
        }
        int iteration = players.size() - 1;
        int nextUp = 1;
        while (iteration > 0) {
            players.remove(nextUp);
            nextUp++;
            if (nextUp > players.size() - 1) {
                nextUp = nextUp % players.size();
            }
            iteration--;
        }
        return players.get(0);
    }

    public static void main(String[] args) {
        System.out.println(whoRemains(7));
        System.out.println(whoRemains(12));
        System.out.println(whoRemains(41));
    }
}
