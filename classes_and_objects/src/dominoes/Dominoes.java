package dominoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        List<Domino> dominoesInOrder = orderDominoes(dominoes);
        System.out.println(dominoesInOrder);
    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
//        dominoes.add(new dominoes.Domino(1, 1));
        return dominoes;
    }

    public static List<Domino> orderDominoes(List<Domino> dominoes) {
        List<Domino> dominoesInOrder = new ArrayList<Domino>();
        int nextDomino = 0;
        for (int i = 0; i < dominoes.size() - 1; i++) {
            nextDomino = i + 2;
            try {
                while (dominoes.get(i).getRightSide() != dominoes.get(i + 1).getLeftSide()) {
                    Collections.swap(dominoes, i + 1, nextDomino);
                    nextDomino++;
                }
                dominoesInOrder.add(dominoes.get(i));
            } catch (Exception e) {
                System.out.println("The rest of the dominoes.Dominoes can't be put in order");
            }
        }
        dominoesInOrder.add(dominoes.get(nextDomino - 1));
        return dominoesInOrder;
    }
}
