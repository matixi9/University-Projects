package Zad1;

public class HardDrive {
    int capacity;
    String type;
    int speed;

    HardDrive(int capacity, String type, int speed) {
        this.capacity = capacity;
        this.type = type;
        this.speed = speed;
    }

    public void showInfo() {
        System.out.println("Capacity: " + capacity + " GB");
        System.out.println("Type: " + type);
        System.out.println("Speed: " + speed + "MB/s");
        System.out.println();
    }
}
