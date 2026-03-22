class MathUtils {

    public static int silnia(int n) {
        if (n > 0) {
            return n * silnia(n - 1);
        } 
        else {
            return 1;
        }
    }

    public static int suma(int a, int b) {
        return a + b;
    }

    public static double srednia(double[] tab) {
    if (tab.length == 0) {
        return 0;
    }

    double suma = 0;
    for (double liczba : tab) {
        suma += liczba;
    }

    return suma / tab.length;
    }

    public static void main(String[] args) {
        int wynik = MathUtils.suma(5 , 7);

        System.out.println("Suma: " + wynik);
        System.out.println("Silnia: " + silnia(5));
        System.out.println("Srednia: " + srednia(new double[]{2, 4, 6}));

    }
}