package Zad6;

import java.util.UUID;

public class Item {
    private UUID itemId;
    private String name;
    private int quantity;

    public Item(UUID itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ")";
    }
}
