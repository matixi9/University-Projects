package Zad4;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Elephant();
        animals[1] = new Lion();
        animals[2] = new Monkey();

        for (Animal animal : animals) {
            animal.printInfo();
        }
    }
}
