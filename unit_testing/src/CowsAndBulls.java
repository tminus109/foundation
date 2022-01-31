import java.util.*;

public class CowsAndBulls {
    Random random = new Random();
    int numberToBeGuessed;
    int[] digitsOfNumberToBeGuessed;
    int guessCount;
    String state;

    CowsAndBulls() {
        this.numberToBeGuessed = random.nextInt(10000 - 1000) + 1000;
        this.digitsOfNumberToBeGuessed = getFourDigits(numberToBeGuessed);
        this.guessCount = 0;
        this.state = "The game hasn't started yet.";
    }

    int[] getFourDigits(int number) {
        int[] digits = new int[4];
        int index = 3;
        while (number > 0) {
            int remainder = number % 10;
            digits[index] = remainder;
            number = number / 10;
            index--;
        }
        return digits;
    }

    void setState(String newState) {
        state = newState;
    }

    void play() {
        int guessedNumber = 0;
        while (guessedNumber != numberToBeGuessed) {
            guessedNumber = guess();
            findCattle(guessedNumber);
            guessCount++;
        }
        System.out.println("Bravo, you've won! This is the number you had to find: "
                + numberToBeGuessed + ". You had to guess " + guessCount + " times.");
        setState("The game is over.");
        System.out.println(state);
    }

    int guess() {
        setState("The game is on.");
        int guess = 0;
        Scanner scanner = new Scanner(System.in);
        while (guess < 1000 || guess > 9999) {
            try {
                System.out.print("Guess number (4 digits): ");
                guess = scanner.nextInt();
                if (guess < 1000 || guess > 9999) {
                    throw new Exception("The number must be 4-digits.\n");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. You need to enter a 4-digit number.\n");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            scanner.nextLine();
        }
        return guess;
    }

    void findCattle(int guessedNumber) {
        int cows = 0;
        int bulls = 0;
        int[] digitsOfGuessedNumber = getFourDigits(guessedNumber);

        HashMap<Integer, Boolean> bullMap = new HashMap<>();
        for (int digit : digitsOfGuessedNumber) {
            bullMap.put(digit, false);
        }

        HashMap<Integer, Boolean> cowMap = new HashMap<>();
        for (int digit : digitsOfGuessedNumber) {
            cowMap.put(digit, false);
        }

        for (int i = 0; i < digitsOfNumberToBeGuessed.length; i++) {
            for (int j = 0; j < digitsOfGuessedNumber.length; j++) {
                if (digitsOfGuessedNumber[j] == digitsOfNumberToBeGuessed[i]) {
                    if (i == j) {
                        cowMap.put(digitsOfGuessedNumber[j], true);
                    } else if (!bullMap.get(digitsOfGuessedNumber[j])
                            && !cowMap.get(digitsOfGuessedNumber[j])) {
                        bullMap.put(digitsOfGuessedNumber[j], true);
                    }
                }
            }
        }

        for (Map.Entry<Integer, Boolean> entry : bullMap.entrySet()) {
            if (entry.getValue()) {
                bulls++;
            }
        }

        for (Map.Entry<Integer, Boolean> entry : cowMap.entrySet()) {
            if (entry.getValue()) {
                cows++;
            }
        }

        System.out.println("You've found " + cows + " cow(s) and " + bulls + " bull(s).");
    }

    public static void main(String[] args) {
        CowsAndBulls cowsAndBulls = new CowsAndBulls();
        cowsAndBulls.play();
    }
}
