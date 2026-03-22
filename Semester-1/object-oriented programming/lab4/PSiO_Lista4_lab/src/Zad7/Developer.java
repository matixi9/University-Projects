package Zad7;

public class Developer {
    private String name;
    private String role;
    private String project;

    public Developer(String name, String role, String project) {
        this.name = name;
        this.role = role;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getProject() {
        return project;
    }
}

