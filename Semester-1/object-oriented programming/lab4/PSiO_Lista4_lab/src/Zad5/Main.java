package Zad5;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("Dream Coders", 5, 5);

        team.addDeveloper(new Developer("Adam", "Java", "Senior"));
        team.addDeveloper(new Developer("Ewa", "Frontend (React)", "Mid"));
        team.addDeveloper(new Developer("Tomek", "DevOps", "Junior"));

        team.addProject(new Project("CRM System", "Java + Spring", "2025-06-01"));
        team.addProject(new Project("Mobile App", "Flutter", "2025-04-15"));

        team.showTeamInfo();
    }
}

