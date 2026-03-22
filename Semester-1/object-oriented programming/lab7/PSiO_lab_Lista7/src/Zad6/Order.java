package Zad6;

import java.util.UUID;

public class Order {
    private UUID orderId;
    private UUID itemId;
    private int amount;

    public Order(UUID orderId, UUID itemId, int amount) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amount = amount;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return  "orderId=" + orderId +
                ", itemId=" + itemId +
                ", amount=" + amount;
    }
}
