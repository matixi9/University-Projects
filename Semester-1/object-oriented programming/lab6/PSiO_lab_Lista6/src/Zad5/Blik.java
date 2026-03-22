package Zad5;

public class Blik implements PaymentMethod {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing Blik payment for: " + amount + " PLN");
        return true;
    }
}
