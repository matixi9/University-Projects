package Zad4;

public abstract class Animal {
    public abstract void makeSound();

    public void printInfo() {
        String name = this.getClass().getSimpleName();

        System.out.print(name + " says: ");
        makeSound();
    }
}
