package Zad8;

public class Main {
    public static void main(String[] args) {

        Network network = new Network("192.168.1.0/24", 120);
        Firewall fw = new Firewall(10);

        network.attachFirewall(fw);

        fw.addRule(new Rule(80, "192.168.1.10", "allow"));
        fw.addRule(new Rule(22, "192.168.1.20", "deny"));
        fw.addRule(new Rule(443, "192.168.1.10", "allow"));

        fw.showRules();

        System.out.println("Test 1: 192.168.1.10:80 -> "
                + (fw.filterConnection("192.168.1.10", 80) ? "DOZWOLONE" : "ZABLOKOWANE"));

        System.out.println("Test 2: 192.168.1.20:22 -> "
                + (fw.filterConnection("192.168.1.20", 22) ? "DOZWOLONE" : "ZABLOKOWANE"));

        System.out.println("Test 3: 192.168.1.50:8080 -> "
                + (fw.filterConnection("192.168.1.50", 8080) ? "DOZWOLONE" : "ZABLOKOWANE"));
    }
}

