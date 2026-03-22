package Zad3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your birth year: ");
            int birthYear = scanner.nextInt();

            int age = calculateAge(birthYear);
            System.out.println("Your age is: " + age);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
        } finally {
            scanner.close();
        }
    }

    static int calculateAge(int birthYear) {
        if (birthYear > 2025) {
            throw new IllegalArgumentException("Birth year cannot be greater than 2025.");
        }
        return 2025 - birthYear;
    }
}
