package Zad3;

public class BookingSystem {

    private Employee[] employees;
    private Device[] devices;
    private int empCount = 0;
    private int devCount = 0;

    public BookingSystem(int maxEmployees, int maxDevices) {
        employees = new Employee[maxEmployees];
        devices = new Device[maxDevices];
    }

    public void addEmployee(Employee e) {
        if (empCount < employees.length) {
            employees[empCount] = e;
            empCount++;
        }
    }

    public void addDevice(Device d) {
        if (devCount < devices.length) {
            devices[devCount] = d;
            devCount++;
        }
    }

    public void bookDevice(Employee e, Device d) {
        if (d.isAvailable() && e.getDevice() == null) {
            d.reserve();
            e.assignDevice(d);
            System.out.println("Pracownik " + e.getName() + " zarezerwował urządzenie: " + d.getName());
        } else {
            System.out.println("Nie można zarezerwować urządzenia!");
        }
    }

    public void releaseDevice(Device d) {
        d.release();

        for (int i = 0; i < empCount; i++) {
            if (employees[i].getDevice() == d) {
                employees[i].removeDevice();
                break;
            }
        }

        System.out.println("Urządzenie " + d.getName() + " zostało zwrócone.");
    }

    public void showActiveBookings() {
        System.out.println("\nAKTYWNE REZERWACJE:");

        for (int i = 0; i < empCount; i++) {
            Device d = employees[i].getDevice();
            if (d != null) {
                System.out.println(employees[i].getName() + " -> " + d.getName());
            }
        }

        System.out.println();
    }
}

