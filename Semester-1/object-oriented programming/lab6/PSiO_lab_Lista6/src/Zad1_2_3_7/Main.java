package Zad1_2_3_7;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Honda", 2010);
        Vehicle motorcycle = new Motorcycle("Kawasaki", 2004);
        Vehicle truck = new Truck("Scania", 2019);

        Vehicle[] vehicles = new Vehicle[5];
        vehicles[0] = new ElectricCar("Suzuki", 2024);
        vehicles[1] = new HybridCar("Audi", 2025, 40, 50);
        vehicles[2] = car;
        vehicles[3] = truck;
        vehicles[4] = motorcycle;

        System.out.println("--- WSZYSTKIE POJAZDY I SERWIS ---");
        for (Vehicle v : vehicles) {
            v.printInfo();
            Workshop.service(v);
        }

        System.out.println("\n--- POJAZDY ELEKTRYCZNE ---");
        Vehicle[] electrics = Filtering.filterElectric(vehicles);
        for (Vehicle v : electrics) {
            v.printInfo();
        }

        System.out.println("\n--- POJAZDY Z ROKU 2024 ---");
        Vehicle[] modernCars = Filtering.filterByYear(vehicles, 2024);
        if (modernCars.length == 0) {
            System.out.println("Brak pojazdów z tego roku.");
        } else {
            for (Vehicle v : modernCars) {
                v.printInfo();
            }
        }
    }
}