package Zad8;

public class Firewall {

    private Rule[] rules;
    private int ruleCount = 0;
    private Network network;   // firewall jest powiązany z siecią

    public Firewall(int maxRules) {
        rules = new Rule[maxRules];
    }

    public void setNetwork(Network n) {
        this.network = n;
    }

    public void addRule(Rule r) {
        if (ruleCount < rules.length) {
            rules[ruleCount] = r;
            ruleCount++;
        } else {
            System.out.println("Nie można dodać więcej reguł!");
        }
    }

    public void showRules() {
        System.out.println("\nReguły firewalla dla sieci: " + network.getSubnet());

        for (int i = 0; i < ruleCount; i++) {
            Rule r = rules[i];
            System.out.println(" - IP: " + r.getIp() +
                    ", port: " + r.getPort() +
                    ", akcja: " + r.getAction());
        }
        System.out.println();
    }

    public boolean filterConnection(String ip, int port) {

        for (int i = 0; i < ruleCount; i++) {
            Rule r = rules[i];

            // dopasowanie reguły
            if (r.getIp().equals(ip) && r.getPort() == port) {
                return r.getAction().equalsIgnoreCase("allow");
            }
        }

        // jeśli brak reguły → domyślnie blokujemy
        return false;
    }
}

