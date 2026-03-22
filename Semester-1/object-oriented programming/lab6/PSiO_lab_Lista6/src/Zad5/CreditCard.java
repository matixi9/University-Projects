package Zad5;

public class CreditCard implements PaymentMethod {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing Credit Card payment for: " + amount + " PLN");
        return true;
    }
}
