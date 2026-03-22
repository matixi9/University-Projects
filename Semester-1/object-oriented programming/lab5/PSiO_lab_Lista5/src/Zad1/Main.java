package Zad1;

public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[10];

        devices[0] = new Laptop("Lenovo", "A23", 2023, 3000);
        devices[1] = new Mobile("Samsung", "A23", 2023, 6);
        devices[2] = new Device("HP", "J2112", 2010);

        devices[0].getInfo();
        devices[1].getInfo();
        devices[2].getInfo();
    }
}
