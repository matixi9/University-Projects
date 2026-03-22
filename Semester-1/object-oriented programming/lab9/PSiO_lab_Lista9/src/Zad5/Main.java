package Zad5;

public class Main {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (UnderageException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }

    static void methodA() throws UnderageException {
        methodB();
    }

    static void methodB() throws UnderageException {
        throw new UnderageException("Error originating from methodB");
    }
}
