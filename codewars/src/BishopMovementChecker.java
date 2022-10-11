import java.util.Objects;

public class BishopMovementChecker {
    public static boolean checkMoves(String startPos, String endPos, int moves) {
        if (Objects.equals(startPos, endPos)) {
            return true;
        }

        if (moves == 0) {
            return false;
        }

        int startChar = startPos.charAt(0);
        int startNum = Character.getNumericValue(startPos.charAt(1));
        int endChar = endPos.charAt(0);
        int endNum = Character.getNumericValue(endPos.charAt(1));

        if (moves == 1) {
            return Math.abs(startChar - endChar) == Math.abs(startNum - endNum);
        }

        if (moves > 1) {
            return (Math.abs(startChar - endChar) + Math.abs(startNum - endNum)) % 2 == 0;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkMoves("a1", "c1", 2));
        System.out.println(checkMoves("a1", "c1", 1));
        System.out.println(checkMoves("a1", "a1", 0));
        System.out.println(checkMoves("a1", "c1", 0));
        System.out.println(checkMoves("d4", "d5", 2));
        System.out.println(checkMoves("d4", "d8", 22));
        System.out.println(checkMoves("d4", "a7", 1));
        System.out.println(checkMoves("d4", "c4", 1));
        System.out.println(checkMoves("d4", "a5", 2));
        System.out.println(checkMoves("a1", "g2", 2));
        System.out.println(checkMoves("a1", "g1", 2));
        System.out.println(checkMoves("d4", "a3", 3));
    }
}
