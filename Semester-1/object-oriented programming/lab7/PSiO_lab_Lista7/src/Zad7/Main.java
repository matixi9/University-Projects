package Zad7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> history = new ArrayList<>();

        history.add(new Transaction("Alice", 0.5, "ETH", 1630000000L));
        history.add(new Transaction("Bob", 150.0, "USD", 1630005000L));
        history.add(new Transaction("Alice", 2.0, "ETH", 1630009000L));
        history.add(new Transaction("Charlie", 0.05, "BTC", 1630001000L));
        history.add(new Transaction("Bob", 50.0, "USD", 1630002000L));
        history.add(new Transaction("Alice", 100.0, "USD", 1630003000L));
        history.add(new Transaction("Charlie", 1.5, "ETH", 1630004000L));
        history.add(new Transaction("Alice", 5.0, "ETH", 1630008000L));

        HashMap<String, ArrayList<Transaction>> groupedByUser = new HashMap<>();

        for (Transaction t : history) {
            String user = t.getUser();
            if (!groupedByUser.containsKey(user)) {
                groupedByUser.put(user, new ArrayList<>());
            }
            groupedByUser.get(user).add(t);
        }

        String userWithMostTransactions = "";
        int maxTransactions = -1;

        for (Map.Entry<String, ArrayList<Transaction>> entry : groupedByUser.entrySet()) {
            int count = entry.getValue().size();
            if (count > maxTransactions) {
                maxTransactions = count;
                userWithMostTransactions = entry.getKey();
            }
        }
        System.out.println("User with the most transactions: " + userWithMostTransactions + " (" + maxTransactions + ")");

        System.out.println("\n--- Total Turnover per User ---");
        for (Map.Entry<String, ArrayList<Transaction>> entry : groupedByUser.entrySet()) {
            double totalAmount = 0;
            for (Transaction t : entry.getValue()) {
                totalAmount += t.getAmount();
            }
            System.out.println(entry.getKey() + ": " + totalAmount);
        }

        Transaction maxEthTransaction = null;
        String targetCurrency = "ETH";

        for (Transaction t : history) {
            if (t.getCurrency().equals(targetCurrency)) {
                if (maxEthTransaction == null || t.getAmount() > maxEthTransaction.getAmount()) {
                    maxEthTransaction = t;
                }
            }
        }
        System.out.println("\nLargest transaction in " + targetCurrency + ": " + maxEthTransaction);

        for (int i = 0; i < history.size() - 1; i++) {
            for (int j = 0; j < history.size() - 1 - i; j++) {
                if (history.get(j).getTimestamp() > history.get(j + 1).getTimestamp()) {
                    Transaction temp = history.get(j);
                    history.set(j, history.get(j + 1));
                    history.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n--- Transactions sorted by timestamp ---");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }
}
