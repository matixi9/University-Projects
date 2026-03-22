package Zad4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        Queue<Ticket> highPriorityQueue = new LinkedList<>();
        Queue<Ticket> normalQueue = new LinkedList<>();

        tickets.add(new Ticket(1, "Server down", "Alice", 10));
        tickets.add(new Ticket(2, "Mouse not working", "Bob", 3));
        tickets.add(new Ticket(3, "Login failed", "Charlie", 9));
        tickets.add(new Ticket(4, "Screen flickering", "David", 5));
        tickets.add(new Ticket(5, "Database error", "Eve", 10));
        tickets.add(new Ticket(6, "Update needed", "Frank", 2));

        for (Ticket ticket : tickets) {
            if (ticket.getPriority() >= 9) {
                highPriorityQueue.add(ticket);
            } else {
                normalQueue.add(ticket);
            }
        }

        System.out.println("--- Processing Tickets ---");
        handleNextTicket(highPriorityQueue, normalQueue);
        handleNextTicket(highPriorityQueue, normalQueue);
        handleNextTicket(highPriorityQueue, normalQueue);
        handleNextTicket(highPriorityQueue, normalQueue);

        System.out.println("\n--- Removing resolved tickets from master list ---");
        tickets.removeIf(ticket -> ticket.isResolved());

        System.out.println("Remaining tickets count: " + tickets.size());

        System.out.println("\n--- Finding ticket for User 'Frank' ---");
        String searchUser = "Frank";
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(searchUser)) {
                System.out.println("Found ticket: " + ticket);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No ticket found for user " + searchUser);
        }
    }

    public static void handleNextTicket(Queue<Ticket> highPriorityQueue, Queue<Ticket> normalQueue) {
        Ticket ticketToHandle = null;

        if (!highPriorityQueue.isEmpty()) {
            ticketToHandle = highPriorityQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            ticketToHandle = normalQueue.poll();
        }

        if (ticketToHandle != null) {
            ticketToHandle.setResolved(true);
            System.out.println("Handled ticket: " + ticketToHandle);
        } else {
            System.out.println("No tickets to handle.");
        }
    }
}
