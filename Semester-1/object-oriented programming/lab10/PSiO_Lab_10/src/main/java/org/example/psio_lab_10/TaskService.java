package org.example.psio_lab_10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskService {
    private ObservableList<Task> tasks;

    public TaskService() {
        this.tasks = FXCollections.observableArrayList();
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        if (task.getTitle() != null && !task.getTitle().isEmpty()) {
            tasks.add(task);
        } else {
            throw new IllegalArgumentException("Warning");
        }
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void toggleTaskStatus(Task task) {
        if (task != null) {
            task.setDone(!task.isDone());

            int index = tasks.indexOf(task);
            tasks.set(index, task);
        }
    }
}
