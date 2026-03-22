package Zad2;

public class Main {
    public static void main(String[] args) {

        AdminPanel panel = new AdminPanel(5);

        panel.addUser(new UserAccount("adam", "1234"));
        panel.addUser(new UserAccount("ewa", "haslo"));
        panel.addUser(new UserAccount("admin", "admin"));

        panel.showUsers();

        panel.blockUser("ewa");
        panel.blockUser("admin");

        panel.showUsers();
    }
}

