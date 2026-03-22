package Zad1;

public class Main {
    public static void main(String[] args) {
        Server s1 = new Server("192.168.1.10", 32, 8, 5);
        s1.addHardDrive(new HardDrive(512, "SSD", 3500));
        s1.addHardDrive(new HardDrive(2000, "HDD", 200));

        Server s2 = new Server("10.0.0.5", 64, 16, 2);
        s2.addHardDrive(new HardDrive(1000, "SSD", 3000));

        Server s3 = new Server("172.16.0.3", 16, 4, 3);
        s3.addHardDrive(new HardDrive(250, "SSD", 500));
        s3.addHardDrive(new HardDrive(250, "SSD", 500));
        s3.addHardDrive(new HardDrive(1000, "HDD", 150));

        s1.showHardwareInfo();
        s2.showHardwareInfo();
        s3.showHardwareInfo();
    }
}
