package Zad3;

public class Main {
    public static void main(String[] args) {

        BookingSystem system = new BookingSystem(5, 5);

        Employee e1 = new Employee("Adam");
        Employee e2 = new Employee("Ewa");

        Device d1 = new Device("Laptop");
        Device d2 = new Device("Tablet");
        Device d3 = new Device("Projektor");

        system.addEmployee(e1);
        system.addEmployee(e2);

        system.addDevice(d1);
        system.addDevice(d2);
        system.addDevice(d3);

        system.bookDevice(e1, d1);
        system.bookDevice(e2, d2);

        system.showActiveBookings();

        system.releaseDevice(d1);

        system.showActiveBookings();
    }
}
