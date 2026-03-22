package Zad7;

public class Transaction {
    private String user;
    private double amount;
    private String currency;
    private long timestamp;

    public Transaction(String user, double amount, String currency, long timestamp) {
        this.user = user;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return  "user='" + user + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", timestamp=" + timestamp;
    }
}
