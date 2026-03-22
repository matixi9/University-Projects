package Zad3;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();

        queue.add(new Customer("Alice", 5));
        queue.add(new Customer("Bob", 3));
        queue.add(new Customer("Charlie", 8));
        queue.add(new Customer("David", 2));
        queue.add(new Customer("Eve", 4));

        double totalServiceTime = 0;
        double totalWaitingTime = 0;
        int customerCount = 0;

        while (!queue.isEmpty()) {
            Customer currentCustomer = queue.poll();

            System.out.println("Serving customer " + currentCustomer.getName() + " (time: " + currentCustomer.getServiceTime() + " min)");

            totalServiceTime += currentCustomer.getServiceTime();
            totalWaitingTime += currentCustomer.getWaitingTime();
            customerCount++;

            for (Customer waitingCustomer : queue) {
                waitingCustomer.addWaitingTime(currentCustomer.getServiceTime());
            }
        }

        if (customerCount > 0) {
            double avgServiceTime = totalServiceTime / customerCount;
            double avgWaitingTime = totalWaitingTime / customerCount;

            System.out.println("\nSimulation finished.");
            System.out.println("Average service time: " + avgServiceTime);
            System.out.println("Average waiting time: " + avgWaitingTime);
        }
    }
}
