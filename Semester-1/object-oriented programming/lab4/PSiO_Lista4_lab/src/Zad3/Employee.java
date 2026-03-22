package Zad3;

public class Employee {
    private String name;
    private Device device;   // urządzenie przypisane pracownikowi

    public Employee(String name) {
        this.name = name;
        this.device = null;
    }

    public String getName() {
        return name;
    }

    public Device getDevice() {
        return device;
    }

    public void assignDevice(Device d) {
        this.device = d;
    }

    public void removeDevice() {
        this.device = null;
    }
}

