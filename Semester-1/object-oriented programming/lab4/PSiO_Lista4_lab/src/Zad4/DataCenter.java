package Zad4;

public class DataCenter {

    private String location;
    private Server[] servers;
    private NetworkSwitch[] switches;

    private int serverCount = 0;
    private int switchCount = 0;

    public DataCenter(String location, int maxServers, int maxSwitches) {
        this.location = location;
        this.servers = new Server[maxServers];
        this.switches = new NetworkSwitch[maxSwitches];
    }

    public void addServer(Server s) {
        if (serverCount < servers.length) {
            servers[serverCount] = s;
            serverCount++;
        } else {
            System.out.println("Nie można dodać więcej serwerów.");
        }
    }

    public void addSwitch(NetworkSwitch sw) {
        if (switchCount < switches.length) {
            switches[switchCount] = sw;
            switchCount++;
        } else {
            System.out.println("Nie można dodać więcej przełączników.");
        }
    }

    public void showInfrastructure() {
        System.out.println("\nDATA CENTER: " + location);

        System.out.println("\nSerwery:");
        for (int i = 0; i < serverCount; i++) {
            System.out.println(" - " + servers[i].getName());
        }

        System.out.println("\nPrzełączniki sieciowe:");
        for (int i = 0; i < switchCount; i++) {
            System.out.println(" - " + switches[i].getModel() + " (" + switches[i].getPorts() + " portów)");
        }

        System.out.println();
    }
}

