public class BishopMovementChecker {
    public static boolean bMC(String start, String end, int moves) {
        int startCharacter = Character.getNumericValue(start.charAt(0));
        int startNumber = Character.getNumericValue(start.charAt(1));
        int endCharacter = Character.getNumericValue(end.charAt(0));
        int endNumber = Character.getNumericValue(end.charAt(1));

        if (start.equals(end)) {
            return true;
        } else if (moves == 0) {
            return false;
        } else if (moves >= 2) {
            return (startNumber % 2 != 0 || endNumber % 2 == 0) &&
                    (startNumber % 2 == 0 || endNumber % 2 != 0);
        } else if (moves == 1) {
            return startCharacter + endCharacter == startNumber + endNumber ||
                    Math.abs(startCharacter - endCharacter) == Math.abs(startNumber - endNumber);
        }
        return false;
    }

    public static void main(String[] args) {
        String start = "a1";
        String end = "c1";
        int moves = 2;

        System.out.println(bMC(start, end, moves));
    }
}
