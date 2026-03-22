package Zad3;

public class Device {
    private String name;
    private boolean available;

    public Device(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void reserve() {
        this.available = false;
    }

    public void release() {
        this.available = true;
    }
}

