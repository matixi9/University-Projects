package Zad2;

public class AdminPanel {
    UserAccount[] users;
    int userCount = 0;

    public AdminPanel(int maxUsers) {
        users = new UserAccount[maxUsers];
    }

    public void addUser(UserAccount user) {
        if (userCount < users.length) {
            users[userCount] = user;
            userCount++;
        } else {
            System.out.println("Nie można dodać więcej użytkowników!");
        }
    }

    public void blockUser(String login) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getLogin().equals(login)) {
                users[i].block();
                System.out.println("Użytkownik '" + login + "' został zablokowany.");
                return;
            }
        }
        System.out.println("Nie znaleziono użytkownika: " + login);
    }

    public void showUsers() {
        System.out.println("LISTA UŻYTKOWNIKÓW:");
        for (int i = 0; i < userCount; i++) {
            users[i].showInfo();
        }
        System.out.println();
    }
}
