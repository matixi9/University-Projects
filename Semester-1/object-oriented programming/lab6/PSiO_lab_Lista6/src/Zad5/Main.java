package Zad5;

public class Main {
    public static void main(String[] args) {
        PaymentMethod[] paymentMethods = new PaymentMethod[4];

        paymentMethods[0] = new CreditCard();
        paymentMethods[1] = new Blik();
        paymentMethods[2] = new CryptoTransfer();
        paymentMethods[3] = new PayPal();

        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethod.process(500);
        }
    }
}
