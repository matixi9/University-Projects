package Zad1;

public class Laptop extends Device {
    private int batteryLife;

    public Laptop(String brand, String model, int year, int batteryLife) {
        super(brand, model, year);
        this.batteryLife = batteryLife;
    }

    public void getInfo(){
        super.getInfo();
        System.out.println("Battery Life: " + batteryLife);
    }
}
