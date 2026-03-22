package Zad5;

public abstract class Passenger {
    private String name;
    private boolean checkedIn;

    public Passenger(String name) {
        this.name = name;
        this.checkedIn = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString() {
        return "name='" + name + "', checkedIn=" + checkedIn;
    }
}
