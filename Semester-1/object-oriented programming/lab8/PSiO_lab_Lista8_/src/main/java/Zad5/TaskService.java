package Zad5;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void initialize() {
        repository.loadData();
    }

    public void saveAndClose() {
        repository.saveData();
    }

    public List<Task> getAllTasks() {
        return repository.getAllTasks();
    }

    public void createTask(String title, String description) {
        Task newTask = new Task(title, description);
        repository.addTask(newTask);
    }

    public boolean completeTask(int index) {
        List<Task> tasks = repository.getAllTasks();
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
            return true;
        }
        return false;
    }
}