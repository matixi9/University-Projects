package Zad1;

public class Server {
    String addressIp;
    int ramCapacity;
    int cpuAmount;

    HardDrive[] drives;
    int driveCount = 0;


    Server(String addressIp, int ramCapacity, int cpuAmount, int drivesAmmount) {
        this.addressIp = addressIp;
        this.ramCapacity = ramCapacity;
        this.cpuAmount = cpuAmount;
        this.drives = new  HardDrive[drivesAmmount];
    }

    public void addHardDrive(HardDrive drive) {
        if (driveCount < drives.length) {
            drives[driveCount] = drive;
            driveCount++;
        } else {
            System.out.println("Nie można dodać więcej dysków!");
        }
    }

    public void showHardwareInfo() {
        System.out.println("SERVER: " + addressIp);
        System.out.println("  RAM: " + ramCapacity + "GB");
        System.out.println("  CPU count: " + cpuAmount);
        System.out.println("  Drives:");

        for (int i = 0; i < driveCount; i++) {
            drives[i].showInfo();
        }

        System.out.println();
    }
}
