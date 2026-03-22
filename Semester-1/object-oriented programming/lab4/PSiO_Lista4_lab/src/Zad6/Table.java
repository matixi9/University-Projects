package Zad6;

public class Table {
    private String name;
    private int columns;
    private int records;

    public Table(String name, int columns, int records) {
        this.name = name;
        this.columns = columns;
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public int getColumns() {
        return columns;
    }

    public int getRecords() {
        return records;
    }
}

