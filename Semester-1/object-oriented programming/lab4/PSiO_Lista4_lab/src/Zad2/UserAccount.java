package Zad2;

public class UserAccount {
    String login;
    String password;
    boolean active;

    UserAccount(String login, String password) {
        this.login = login;
        this.password = password;
        this.active = true;
    }

    public String getLogin() {
        return login;
    }

    public void block() {
        this.active = false;
    }

    public void showInfo() {
        System.out.println("Login: " + login +
                ", Hasło: " + password +
                ", Status: " + (active ? "Aktywne" : "Zablokowane"));
    }
}
