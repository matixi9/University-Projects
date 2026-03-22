class Kalkulator {

    public double dodaj(double a, double b) {
        return a + b;
    }

    public double odejmij(double a, double b) {
        return a - b;
    }

    public double pomnoz(double a, double b) {
        return a * b;
    }

    public double podziel(double a, double b) {
        return a / b;
    }

    public static void opis() {
        System.out.println("Kalkulator, Mateusz Reszel");
    }

    public static void main(String[] args) {

    Kalkulator k = new Kalkulator();

    System.out.println("Wynik dodawania: " + k.dodaj(3, 5));
    System.out.println("Wynik odejmowania: " + k.odejmij(3, 5));
    System.out.println("Wynik mnozenia: " + k.pomnoz(3, 5));
    System.out.println("Wynik dzielenia: " + k.podziel(3, 5));
    opis();
    }
}