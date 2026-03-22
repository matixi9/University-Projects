package Zad2;

public class Manager extends Employee {

    public Manager(String name, int salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.5;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Bonus: " + calculateBonus());
    }
}
