package Zad3;

public class Customer {
    private String name;
    private int serviceTime;
    private int waitingTime;

    public Customer(String name, int serviceTime) {
        this.name = name;
        this.serviceTime = serviceTime;
        this.waitingTime = 0;
    }

    public String getName() {
        return name;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void addWaitingTime(int time) {
        this.waitingTime += time;
    }
}
