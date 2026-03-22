import java.util.Scanner;

public class KonwerterTemperatur {

    public static double naFahrenheita(double celsjusz) {
        return celsjusz * 9 / 5 + 32;
    }

    public static double naCelsjusza(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Temperatura w Celsjuszach: ");
        double celsjusz = s.nextDouble();
        double fahrenheit = naFahrenheita(celsjusz);

        System.out.print("Temperatura w Fahrenheitach: ");
        double fahrenheit2 = s.nextDouble();
        double celsjusz2 = naCelsjusza(fahrenheit2);

        System.out.println("--------------------------------------------------");
        System.out.println("*Celsjusz na Fahrenheita: ** Fahrenheit na Celsjusza:*");
        System.out.println("-----------------------------------------");
        System.out.println( " ****** " + fahrenheit + " ***** " + celsjusz2 + " ****** ");
        System.out.println("--------------------------------------------------");
    }
}