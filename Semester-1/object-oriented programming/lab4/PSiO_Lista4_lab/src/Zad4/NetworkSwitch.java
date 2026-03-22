package Zad4;

public class NetworkSwitch {
    private String model;
    private int ports;

    public NetworkSwitch(String model, int ports) {
        this.model = model;
        this.ports = ports;
    }

    public String getModel() {
        return model;
    }

    public int getPorts() {
        return ports;
    }
}
