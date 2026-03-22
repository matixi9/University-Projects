package Zad7;

public class Main {
    public static void main(String[] args) {

        WebApplication app = new WebApplication("ShopOnline", "1.3.0", "running", 5);

        Module m1 = new Module("Auth", "Obsługa logowania", "1.0");
        Module m2 = new Module("Cart", "Koszyk zakupowy", "2.1");
        Module m3 = new Module("Payments", "Płatności online", "1.4");

        Developer d1 = new Developer("Kuba", "Backend Developer", "ShopOnline");
        Developer d2 = new Developer("Anna", "Frontend Developer", "ShopOnline");

        app.addModule(m1);
        app.addModule(m2);
        app.addModule(m3);

        app.assignDeveloperToModule(m1, d1);
        app.assignDeveloperToModule(m2, d2);

        app.showModules();
    }
}

