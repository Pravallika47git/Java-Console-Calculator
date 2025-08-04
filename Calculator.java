import java.util.Scanner;

public class Calculator {

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division with exception throwing
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "y"; 
        do {
            System.out.println("\n=== Java Console Calculator ===");
            System.out.println("Select the operation to perform:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("Enter your choice (1-4): ");
            String operation = scanner.nextLine();

            // Validate operation first
            if (!operation.equals("1") && !operation.equals("2") &&
                !operation.equals("3") && !operation.equals("4")) {
                System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                continue; 
            }

            // Ask for numbers only after valid operation
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine(); 
            double result;
            try {
                switch (operation) {
                    case "1":
                        result = add(num1, num2);
                        System.out.println("Result (Addition): " + result);
                        break;
                    case "2":
                        result = subtract(num1, num2);
                        System.out.println("Result (Subtraction): " + result);
                        break;
                    case "3":
                        result = multiply(num1, num2);
                        System.out.println("Result (Multiplication): " + result);
                        break;
                    case "4":
                        result = divide(num1, num2);
                        System.out.println("Result (Division): " + result);
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage()); // Handle divide-by-zero
            }

            // Ask user if they want to continue
            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("y"));

        scanner.close();
        System.out.println("Calculator closed. Have a great day!");
    }
}

