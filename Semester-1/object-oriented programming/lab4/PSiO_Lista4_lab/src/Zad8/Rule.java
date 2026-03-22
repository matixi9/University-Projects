package Zad8;

public class Rule {
    private int port;
    private String ip;
    private String action;  // "allow" lub "deny"

    public Rule(int port, String ip, String action) {
        this.port = port;
        this.ip = ip;
        this.action = action;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public String getAction() {
        return action;
    }
}

