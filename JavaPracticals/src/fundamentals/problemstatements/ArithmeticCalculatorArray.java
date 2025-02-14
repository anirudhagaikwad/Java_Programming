package fundamentals.problemstatements;

import java.util.Scanner;

public class ArithmeticCalculatorArray {

    // Method to take input and store in an array
    public static void getNumbers(double[] numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        numbers[0] = scanner.nextDouble();
        System.out.print("Enter second number: ");
        numbers[1] = scanner.nextDouble();
        scanner.close();
    }

    // Method to perform arithmetic operations and store result in an array
    public static void calculate(double[] numbers, double[] result, int choice) {
        switch (choice) {
            case 1: result[0] = numbers[0] + numbers[1]; break; // Addition
            case 2: result[0] = numbers[0] - numbers[1]; break; // Subtraction
            case 3: result[0] = numbers[0] * numbers[1]; break; // Multiplication
            case 4: result[0] = (numbers[1] != 0) ? numbers[0] / numbers[1] : Double.NaN; break; // Division
            case 5: result[0] = (numbers[1] != 0) ? numbers[0] % numbers[1] : Double.NaN; break; // Modulus
        }
    }

    // Method to display the result
    public static void displayResult(double[] result) {
        if (Double.isNaN(result[0])) {
            System.out.println("Error: Invalid operation (e.g., division by zero).");
        } else {
            System.out.println("Result: " + result[0]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double[] numbers = new double[2]; // Array to store input numbers
        double[] result = new double[1];  // Array to store result

        do {
            // Display menu
            System.out.println("\nArithmetic Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 5) {
                getNumbers(numbers);        // Get input numbers
                calculate(numbers, result, choice); // Perform calculation
                displayResult(result);      // Display result
            } else if (choice == 6) {
                System.out.println("Exiting the calculator. Goodbye!");
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
