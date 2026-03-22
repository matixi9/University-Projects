package Zad1_2;

public class Calculator {

    public static int divide(int a, int b) {
        return a / b;
    }

    public static int divideWithException(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero");
        }
        return a / b;
    }

    public static boolean isAdult(int age) {
        return age >= 18;
    }
}
