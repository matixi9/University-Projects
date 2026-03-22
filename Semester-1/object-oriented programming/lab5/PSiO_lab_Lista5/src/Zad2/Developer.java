package Zad2;

public class Developer extends Employee {

    public Developer(String name, int salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.2;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Bonus: " + calculateBonus());
    }
}
