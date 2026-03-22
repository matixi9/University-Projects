package Zad1;

public class Product {
    private String name;
    private double price;
    private String category;
    private boolean discounted;

    public Product(String name, double price, String category, boolean discounted) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.discounted = discounted;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    @Override
    public String toString() {
        return name + " | " + category + " | " + price + " zł";
    }
}
