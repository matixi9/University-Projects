package Zad1_2;

public class Main {
    public static void main(String[] args) {
        Calculator.divide(4,2);

        try {
            Calculator.divideWithException(4,0);
        }
        catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

        try {
            Calculator.divide(4,0);
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

    }
}
