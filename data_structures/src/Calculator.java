import java.util.Scanner;

public class Calculator {
    public static void calculate() {
        System.out.println("Please type in the expression:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");
        String operator = splitInput[0];
        int a = Integer.parseInt(splitInput[1]);
        int b = Integer.parseInt(splitInput[2]);
        switch (operator) {
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            case "*" -> System.out.println(a * b);
            case "/" -> System.out.println(a / b);
            case "%" -> System.out.println(a % b);
        }
    }

    public static void main(String[] args) {
        calculate();
    }
}
