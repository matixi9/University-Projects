package Zad1_2_3_7;

public abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public abstract double getFuelConsumption();

    public void printInfo() {
        System.out.println("\nBrand: " + this.brand);
        System.out.println("Year: " + this.year);
        System.out.println("FuelConsumption: " + this.getFuelConsumption() + " L");
    }
}
