package Zad1_2_3_7;

public class ElectricCar extends Car implements Electric {
    public ElectricCar(String brand, int year) {
        super(brand, year);
    }

    @Override
    public int getBatteryLevel() {
        return 100;
    }
}
