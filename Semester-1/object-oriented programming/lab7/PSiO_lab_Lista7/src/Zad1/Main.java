package Zad1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        Random rand = new Random();

        String[] names = {"Milk", "Cheese", "Water",
                "Orange Juice", "Ham",
                "Bread", "Chocolate", "Pizza",
                "Gummy Bears", "Cola"};

        String[] category = {"Dairy", "Dairy", "Drinks",
                "Drinks", "Meat",
                "Bread", "Sweets", "Bread",
                "Sweets", "Drinks"};

        for (int i = 0; i < 10; i++) {
            double rawPrice = 5 + rand.nextDouble() * 95;
            double finalPrice = Math.round(rawPrice * 100.0) / 100.0;

            inventory.add(new Product(names[i], finalPrice, category[i], false));
        }

        System.out.println("-------All Products-------");
        for (Product product : inventory) {
            System.out.println(product);
        }

        System.out.println("\n-------Dairy cheaper than 20zl-------");
        for (Product p : inventory) {
            if (p.getCategory().equals("Dairy") && p.getPrice() < 20) {
                System.out.println(p);
            }
        }

        System.out.println("\n-------Setting discounts for products more expensive than 40zl-------");
        for (Product p : inventory) {
            if (p.getPrice() > 40) {
                p.setDiscounted(true);
                System.out.println(p);
            }
        }

        System.out.println("\n-------Deleting Bread-------");
        for (int i = inventory.size() - 1; i >= 0; i--) {
            Product p = inventory.get(i);
            if (p.getName().equals("Bread")) {
                inventory.remove(i);
                System.out.println(p);
            }
        }

        System.out.println("\n-------Sorting by price (ascending)-------");
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = 0; j < inventory.size() - 1; j++) {
                if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()) {
                    Product temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
        for (Product p : inventory) System.out.println(p);

        System.out.println("\n-------Sorting by price (descending)-------");
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = 0; j < inventory.size() - 1; j++) {
                if (inventory.get(j).getPrice() < inventory.get(j + 1).getPrice()) {
                    Product temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
        for (Product p : inventory) System.out.println(p);

        System.out.println("\n-------Sorting Alphabetically-------");
        for (int i = 0; i < inventory.size(); i++) {
            for (int j = 0; j < inventory.size() - 1; j++) {
                if (inventory.get(j).getName().compareTo(inventory.get(j + 1).getName()) > 0) {
                    Product temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
        for (Product p : inventory) System.out.println(p);
    }
}