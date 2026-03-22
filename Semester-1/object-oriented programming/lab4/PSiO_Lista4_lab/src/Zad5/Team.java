package Zad5;

public class Team {

    private String teamName;

    private Developer[] developers;
    private Project[] projects;

    private int developerCount = 0;
    private int projectCount = 0;

    public Team(String teamName, int maxDevelopers, int maxProjects) {
        this.teamName = teamName;
        this.developers = new Developer[maxDevelopers];
        this.projects = new Project[maxProjects];
    }

    public void addDeveloper(Developer d) {
        if (developerCount < developers.length) {
            developers[developerCount] = d;
            developerCount++;
        } else {
            System.out.println("Nie można dodać więcej programistów!");
        }
    }

    public void addProject(Project p) {
        if (projectCount < projects.length) {
            projects[projectCount] = p;
            projectCount++;
        } else {
            System.out.println("Nie można dodać więcej projektów!");
        }
    }

    public void showTeamInfo() {
        System.out.println("\nZESPÓŁ: " + teamName);

        System.out.println("\nProgramiści:");
        for (int i = 0; i < developerCount; i++) {
            Developer d = developers[i];
            System.out.println(" - " + d.getName() +
                    " (" + d.getSpecialization() + ", poziom: " + d.getExperienceLevel() + ")");
        }

        System.out.println("\nProjekty:");
        for (int i = 0; i < projectCount; i++) {
            Project p = projects[i];
            System.out.println(" - " + p.getName() +
                    " [technologia: " + p.getTechnology() +
                    ", deadline: " + p.getDeadline() + "]");
        }

        System.out.println();
    }
}

