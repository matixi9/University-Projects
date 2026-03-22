package Zad5;

public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);
        ConsoleUI ui = new ConsoleUI(service);

        ui.startApp();
    }
}
