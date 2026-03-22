package Zad2;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Developer("Daniel", 20000);
        employees[1] = new Manager("Bogdan", 20000);

        employees[0].printInfo();
        employees[1].printInfo();
    }
}
