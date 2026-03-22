package Zad4;

public class Ticket {
    private int id;
    private String title;
    private String user;
    private int priority;
    private boolean resolved;

    public Ticket(int id, String title, String user, int priority) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.priority = priority;
        this.resolved = false;
    }

    public int getPriority() {
        return priority;
    }

    public String getUser() {
        return user;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", user='" + user + '\'' +
                ", priority=" + priority +
                ", resolved=" + resolved;
    }
}
