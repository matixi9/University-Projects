package Zad1_2_3_7;

public class HybridCar extends Car implements Electric {
    protected int fuelLevel;
    protected int batteryLevel;

    public HybridCar(String brand, int year, int fuelLevel, int batteryLevel) {
        super(brand, year);
        this.fuelLevel = fuelLevel;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public double getFuelConsumption() {
        return 6 - (double) batteryLevel / 100 * 6;
    }
}
