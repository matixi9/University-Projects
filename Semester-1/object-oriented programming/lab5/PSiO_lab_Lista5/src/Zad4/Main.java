package Zad4;

public class Main {
    public static void main(String[] args) {
        Deployable backendAPI = new BackendService();
        Deployable userInterface = new FrontendApp();

        DeploymentManager.runDeployment(backendAPI);
        DeploymentManager.runDeployment(userInterface);
    }
}
