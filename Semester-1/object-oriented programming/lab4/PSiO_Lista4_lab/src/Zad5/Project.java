package Zad5;

public class Project {
    private String name;
    private String technology;
    private String deadline;

    public Project(String name, String technology, String deadline) {
        this.name = name;
        this.technology = technology;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getTechnology() {
        return technology;
    }

    public String getDeadline() {
        return deadline;
    }
}

