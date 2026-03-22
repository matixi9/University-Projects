package Zad5;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Task {
    private String title;
    private String description;
    private boolean isDone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
        this.dueDate = LocalDate.now();
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDone() { return isDone; }
    public void setDone(boolean done) { isDone = done; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + title + " (" + description + ") - termin: " + dueDate;
    }
}