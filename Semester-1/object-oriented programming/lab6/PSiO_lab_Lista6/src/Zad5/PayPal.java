package Zad5;

public class PayPal implements PaymentMethod {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing PayPal payment for: " + amount + " PLN");
        return true;
    }
}
