package org.example.psio_lab_10;

import java.time.LocalDate;

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

public class Task {
    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;
    private boolean isDone;

    public Task(String title, String description, LocalDate date, Priority priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public String getTitle() {return title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public Priority getPriority() {return priority;}

    public void setPriority(Priority priority) {this.priority = priority;}

    public boolean isDone() {return isDone;}

    public void setDone(boolean done) {this.isDone = done;}

    public void setTitle(String title) {this.title = title;}

    @Override
    public String toString() {
        String status = isDone ? "[DONE] " : "";

        return status + title + " (" + priority + ") - " + date;
    }
}
