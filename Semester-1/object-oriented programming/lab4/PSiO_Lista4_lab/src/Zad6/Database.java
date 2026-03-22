package Zad6;

public class Database {

    private String name;
    private String type;  // SQL lub NoSQL

    private Table[] tables;
    private int tableCount = 0;

    public Database(String name, String type, int maxTables) {
        this.name = name;
        this.type = type;
        this.tables = new Table[maxTables];
    }

    public void addTable(Table t) {
        if (tableCount < tables.length) {
            tables[tableCount] = t;
            tableCount++;
        } else {
            System.out.println("Nie można dodać więcej tabel.");
        }
    }

    public void showTables() {
        System.out.println("\nBaza danych: " + name + " (" + type + ")");
        System.out.println("Tabele:");

        for (int i = 0; i < tableCount; i++) {
            Table t = tables[i];
            System.out.println(" - " + t.getName() +
                    " [kolumny: " + t.getColumns() +
                    ", rekordy: " + t.getRecords() + "]");
        }

        System.out.println();
    }

    public int getTotalRecords() {
        int sum = 0;
        for (int i = 0; i < tableCount; i++) {
            sum += tables[i].getRecords();
        }
        return sum;
    }
}

