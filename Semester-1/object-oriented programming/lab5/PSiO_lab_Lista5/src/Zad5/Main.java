package Zad5;

public class Main {
    public static void main(String[] args) {
        Client[] clients = new Client[3];

        clients[0] = new IndividualClient("123123123", "Poland", "Adam", "Nowak", 25);
        clients[1] = new IndividualClient("111222333", "USA", "John", "Jeferson", 16);
        clients[2] = new BusinessClient("555666777", "Poland", "PL501002003", "Super Kod Sp. z o.o.");

        System.out.println("--- BANK SYSTEM START ---");
        for (Client client : clients) {
            client.createAccount();
            client.creditCheck(2000);
        }
    }
}
