import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        String userInput = "";
        System.out.println("Welcome to Calculator. Enter numbers or press q to exit \n");

        while (!userInput.equalsIgnoreCase("q")) {

            try {
                double result = 0;
                System.out.println("Enter the first number: ");
                int firstNumber = scanner.nextInt();
                System.out.println("Enter the second number: ");
                int secondNumber = scanner.nextInt();
                System.out.println("Enter the operator (+, -, *, /, !): ");
                String operator = scanner.next();
                System.out.println(calculate(firstNumber, secondNumber, operator));
            } catch (InputMismatchException | ArithmeticException exception) {
                System.out.println("Wrong input data!");
            }
            userInput = scanner.nextLine();
            System.out.println("Calculate completed. Enter numbers or press q to exit");
        }

    }

    public static double calculate(int numberOne, int numberTwo, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = plus(numberOne, numberTwo);
                break;
            case "-":
                result = minus(numberOne, numberTwo);
                break;
            case "*":
                result = multiply(numberOne, numberTwo);
                break;
            case "/":
                if (numberTwo == 0) {
                    System.out.println("Can't divide by zero!");
                    break;
                }
                result = divide(numberOne, numberTwo);
                break;
            case "!":
                result = factorial(numberOne);
                break;
            default:
                result = 0;
                System.out.println("Wrong operator, try again");
                break;
        }
        return result;
    }

    private static int plus(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    private static int minus(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private static int multiply(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    private static double divide(int numberOne, int numberTwo) {
        return (double) numberOne / numberTwo;
    }

    private static int factorial(int numberOne) {
        int res = 1;
        for (int i = 1; i <= numberOne; i++) {
            res *= i;
        }
        return res;
    }
}