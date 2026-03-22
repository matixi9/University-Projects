package Zad4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            checkAge(age);

        } catch (UnderageException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }

    static void checkAge(int age) throws UnderageException {
        if (age < 18) {
            throw new UnderageException("You are strictly too young (under 18).");
        }
        System.out.println("Access granted.");
    }
}
