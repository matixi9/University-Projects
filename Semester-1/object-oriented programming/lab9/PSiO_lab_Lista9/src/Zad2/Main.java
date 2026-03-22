package Zad2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            String inputOne = scanner.next();
            int firstNumber = Integer.parseInt(inputOne);

            System.out.print("Enter the second number: ");
            String inputTwo = scanner.next();
            int secondNumber = Integer.parseInt(inputTwo);

            int result = firstNumber / secondNumber;
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: You entered text instead of an integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }
}
