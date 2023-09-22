package org.javatasks.simplecalculator;



import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 5;

        System.out.println("Simple Calculator");

        double firstNumber = getUserInput("Enter the first number: ");
        double secondNumber = getUserInput("Enter the second number: ");
        int operationChoice;

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter the number corresponding to the operation: ");

            if (scanner.hasNextInt()) {
                operationChoice = scanner.nextInt();
                if (operationChoice >= 1 && operationChoice <= 4) {
                    break;
                } else {
                    System.out.println("Invalid operation choice. Please enter a number between 1 and 4.");
                    scanner.nextLine(); // Clear the input buffer
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }

            attempts--;

            if (attempts == 0) {
                System.out.println("You've reached the maximum number of attempts. Exiting the program.");
                System.exit(1);
            }
        }

        double result = 0.0;

        switch (operationChoice) {
            case 1:
                result = firstNumber + secondNumber;
                break;
            case 2:
                result = firstNumber - secondNumber;
                break;
            case 3:
                result = firstNumber * secondNumber;
                break;
            case 4:
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    System.exit(1);
                }
                break;
            default:
                break;
        }

        System.out.println("Result: " + result);
    }

    private static double getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double userInput = 0.0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                userInput = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        return userInput;
    }
}

