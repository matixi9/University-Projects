package Zad5;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final TaskService taskService;
    private final Scanner scanner;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void startApp() {
        taskService.initialize();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayTasks();
                    break;
                case "2":
                    promptAddTask();
                    break;
                case "3":
                    promptMarkDone();
                    break;
                case "4":
                    taskService.saveAndClose();
                    running = false;
                    break;
                default:
                    System.out.println("Nieznana opcja.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- ToDo Manager ---");
        System.out.println("1. Pokaż zadania");
        System.out.println("2. Dodaj zadanie");
        System.out.println("3. Oznacz zadanie jako wykonane");
        System.out.println("4. Zapisz i wyjdź");
        System.out.print("Twój wybór: ");
    }

    private void displayTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Lista jest pusta.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void promptAddTask() {
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Opis: ");
        String desc = scanner.nextLine();
        taskService.createTask(title, desc);
    }

    private void promptMarkDone() {
        displayTasks();
        if (taskService.getAllTasks().isEmpty()) return;

        System.out.print("Podaj numer zadania do zakończenia: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskService.completeTask(index)) {
                System.out.println("Sukces.");
            } else {
                System.out.println("Błędny numer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("To nie jest liczba.");
        }
    }
}