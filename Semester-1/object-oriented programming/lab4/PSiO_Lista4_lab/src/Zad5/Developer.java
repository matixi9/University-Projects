package Zad5;

public class Developer {
    private String name;
    private String specialization;
    private String experienceLevel;

    public Developer(String name, String specialization, String experienceLevel) {
        this.name = name;
        this.specialization = specialization;
        this.experienceLevel = experienceLevel;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }
}

