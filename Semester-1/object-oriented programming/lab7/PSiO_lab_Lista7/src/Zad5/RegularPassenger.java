package Zad5;

public class RegularPassenger extends Passenger {
    private boolean hasExtraLuggage;

    public RegularPassenger(String name, boolean hasExtraLuggage) {
        super(name);
        this.hasExtraLuggage = hasExtraLuggage;
    }

    public boolean isHasExtraLuggage() {
        return hasExtraLuggage;
    }

    @Override
    public String toString() {
        return  "name='" + getName() + '\'' +
                ", checkedIn=" + isCheckedIn() +
                ", hasExtraLuggage=" + hasExtraLuggage;
    }
}
