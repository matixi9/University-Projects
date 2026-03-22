package Zad7;

public class Module {
    private String name;
    private String description;
    private String version;

    private Developer developer; // przypisany twórca

    public Module(String name, String description, String version) {
        this.name = name;
        this.description = description;
        this.version = version;
    }

    public void assignDeveloper(Developer d) {
        this.developer = d;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public Developer getDeveloper() {
        return developer;
    }
}

