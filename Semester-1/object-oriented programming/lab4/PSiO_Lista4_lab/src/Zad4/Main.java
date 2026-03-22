package Zad4;

public class Main {
    public static void main(String[] args) {

        DataCenter dc = new DataCenter("Warszawa", 5, 5);

        dc.addServer(new Server("Server-01"));
        dc.addServer(new Server("Server-02"));
        dc.addServer(new Server("Server-Backup"));

        dc.addSwitch(new NetworkSwitch("Cisco Catalyst 2960", 24));
        dc.addSwitch(new NetworkSwitch("Juniper EX2200", 48));

        dc.showInfrastructure();
    }
}

