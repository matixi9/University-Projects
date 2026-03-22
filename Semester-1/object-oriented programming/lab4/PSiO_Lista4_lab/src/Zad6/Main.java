package Zad6;

public class Main {
    public static void main(String[] args) {

        Database db = new Database("SalesDB", "SQL", 5);

        db.addTable(new Table("Customers", 6, 1200));
        db.addTable(new Table("Orders", 10, 3500));
        db.addTable(new Table("Products", 8, 850));

        db.showTables();

        System.out.println("Łączna liczba rekordów: " + db.getTotalRecords());
    }
}

