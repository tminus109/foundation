public class BunniesAgain {
    static int countBunnyEars(int bunnies) {
        if (bunnies <= 0) {
            return 0;
        } else {
            if ((bunnies % 2) == 0) {
                return 2 + countBunnyEars(bunnies - 1);
            } else {
                return 1 + countBunnyEars(bunnies - 1);
            }
        }
    }

    public static void main(String[] args) {
        int bunnies = 10;
        System.out.println(countBunnyEars(bunnies));
    }
}
