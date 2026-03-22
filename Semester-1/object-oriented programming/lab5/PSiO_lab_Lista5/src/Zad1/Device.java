package Zad1;

public class Device {
    private String brand;
    private String model;
    private int year;

    public Device(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("\nBrand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
