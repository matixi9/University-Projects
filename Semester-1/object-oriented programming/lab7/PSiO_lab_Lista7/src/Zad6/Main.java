package Zad6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> inventory = new ArrayList<>();
        Queue<Order> orders = new LinkedList<>();

        UUID idLaptop = UUID.randomUUID();
        UUID idMouse = UUID.randomUUID();
        UUID idKeyboard = UUID.randomUUID();

        inventory.add(new Item(idLaptop, "Laptop", 10));
        inventory.add(new Item(idMouse, "Mouse", 15));
        inventory.add(new Item(idKeyboard, "Keyboard", 5));

        orders.add(new Order(UUID.randomUUID(), idLaptop, 2));
        orders.add(new Order(UUID.randomUUID(), idMouse, 20));
        orders.add(new Order(UUID.randomUUID(), idLaptop, 5));
        orders.add(new Order(UUID.randomUUID(), idKeyboard, 3));
        orders.add(new Order(UUID.randomUUID(), idMouse, 5));
        orders.add(new Order(UUID.randomUUID(), idKeyboard, 4));

        System.out.println("--- Starting Simulation ---");

        while (!orders.isEmpty()) {
            int currentQueueSize = orders.size();
            boolean anyOrderFulfilledInThisCycle = false;

            for (int i = 0; i < currentQueueSize; i++) {
                Order currentOrder = orders.poll();

                Item foundItem = null;
                for (Item item : inventory) {
                    if (item.getItemId().equals(currentOrder.getItemId())) {
                        foundItem = item;
                        break;
                    }
                }

                if (foundItem != null) {
                    if (foundItem.getQuantity() >= currentOrder.getAmount()) {
                        foundItem.setQuantity(foundItem.getQuantity() - currentOrder.getAmount());
                        System.out.println("Fulfilled: " + currentOrder + ". Remaining Stock: " + foundItem.getQuantity());
                        anyOrderFulfilledInThisCycle = true;
                    } else {
                        System.out.println("Not enough stock for: " + currentOrder + ". Moved to end of queue.");
                        orders.add(currentOrder);
                    }
                } else {
                    System.out.println("Item not found for order. Discarding.");
                }
            }

            if (!anyOrderFulfilledInThisCycle) {
                System.out.println("\nSimulation stopped: No more orders can be fulfilled with current inventory.");
                break;
            }
        }

        if (orders.isEmpty()) {
            System.out.println("\nAll orders have been fulfilled!");
        } else {
            System.out.println("Unfulfilled orders remaining: " + orders.size());
        }
    }
}
