package Zad2;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public void printInfo() {
        System.out.println("\nName: " + this.name);
        System.out.println("Salary: " + this.salary);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
