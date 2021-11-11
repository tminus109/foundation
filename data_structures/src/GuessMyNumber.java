import java.util.Scanner;

public class GuessMyNumber {
    public static void guess() {
        System.out.println("Choose lowerBound:");
        Scanner scanner = new Scanner(System.in);
        int lowerBound = scanner.nextInt();
        System.out.println("Choose upperBound:");
        int upperBound = scanner.nextInt();
        int randomInt = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        System.out.println("Guess:");
        int guess = scanner.nextInt();
        int lives = 5;
        while (lives != 0) {
            if (randomInt == guess) {
                System.out.println("Congratulations! You won!");
                break;
            } else if (randomInt > guess) {
                lives--;
                System.out.println("Too low, guess again:");
                guess = scanner.nextInt();
            } else {
                lives--;
                System.out.println("Too high, guess again:");
                guess = scanner.nextInt();
            }
        }
        if (lives == 0) {
            System.out.println("Sorry, out of lives!");
        }
    }

    public static void main(String[] args) {
        guess();
    }
}
