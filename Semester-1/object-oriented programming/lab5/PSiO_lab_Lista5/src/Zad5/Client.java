package Zad5;

public abstract class Client {
    protected String phone;
    protected String country;

    public Client(String phone, String country) {
        this.phone = phone;
        this.country = country;
    }

    public abstract void createAccount();

    public abstract void deleteAccount();

    public void creditCheck(double amount) {
        if (this instanceof CreditCapable) {
            CreditCapable capableClient = (CreditCapable) this;

            boolean decision = capableClient.checkCreditworthiness(amount);

            if (decision) {
                System.out.println(" -> LOAN GRANTED.");
            } else {
                System.out.println(" -> LOAN DENIED (insufficient credit score or age restrictions).");
            }
        } else {
            System.out.println(" -> This client type is not eligible for loans.");
        }
        System.out.println("--------------------------------------------------");
    }
}