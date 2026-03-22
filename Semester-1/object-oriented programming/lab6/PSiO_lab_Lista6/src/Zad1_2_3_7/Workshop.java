package Zad1_2_3_7;

public class Workshop {
    public static void service(Vehicle v) {

        if (v instanceof Motorcycle) {
            System.out.println("Smarowanie lancucha");
        }
        else if (v instanceof Truck) {
            System.out.println("Kontrola hamulcow");
        }
        else if (v instanceof ElectricCar) {
            System.out.println("Kontrola baterii");
        }
        else if  (v instanceof Car) {
            System.out.println("Wymiana oleju");
        }
    }
}
