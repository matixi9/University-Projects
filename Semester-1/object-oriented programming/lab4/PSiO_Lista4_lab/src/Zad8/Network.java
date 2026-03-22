package Zad8;

public class Network {
    private String subnet;
    private int devices;

    private Firewall firewall;   // 1:1 z firewall

    public Network(String subnet, int devices) {
        this.subnet = subnet;
        this.devices = devices;
    }

    public void attachFirewall(Firewall f) {
        this.firewall = f;
        f.setNetwork(this);
    }

    public Firewall getFirewall() {
        return firewall;
    }

    public String getSubnet() {
        return subnet;
    }
}

