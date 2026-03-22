package Zad7;

public class WebApplication {

    private String name;
    private String version;
    private String status;

    private Module[] modules;
    private int moduleCount = 0;

    public WebApplication(String name, String version, String status, int maxModules) {
        this.name = name;
        this.version = version;
        this.status = status;
        this.modules = new Module[maxModules];
    }

    public void addModule(Module m) {
        if (moduleCount < modules.length) {
            modules[moduleCount] = m;
            moduleCount++;
        } else {
            System.out.println("Brak miejsca na kolejne moduły!");
        }
    }

    public void assignDeveloperToModule(Module m, Developer d) {
        for (int i = 0; i < moduleCount; i++) {
            if (modules[i] == m) {
                modules[i].assignDeveloper(d);
                return;
            }
        }
        System.out.println("Nie znaleziono modułu w aplikacji!");
    }

    public void showModules() {
        System.out.println("\nModuły aplikacji: " + name + " (wersja: " + version + ")");
        for (int i = 0; i < moduleCount; i++) {
            Module m = modules[i];
            System.out.print(" - " + m.getName() + " v" + m.getVersion() +
                    " | " + m.getDescription());

            if (m.getDeveloper() != null) {
                Developer d = m.getDeveloper();
                System.out.print(" | Dev: " + d.getName() +
                        " (" + d.getRole() + ")");
            } else {
                System.out.print(" | Dev: brak");
            }

            System.out.println();
        }
    }
}

