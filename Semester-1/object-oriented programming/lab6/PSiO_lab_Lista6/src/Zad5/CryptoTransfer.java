package Zad5;

public class CryptoTransfer implements PaymentMethod {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing Crypto Transfer payment for: " + amount + " PLN");
        return true;
    }
}
