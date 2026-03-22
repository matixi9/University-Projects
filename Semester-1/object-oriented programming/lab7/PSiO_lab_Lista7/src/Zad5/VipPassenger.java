package Zad5;

public class VipPassenger extends Passenger {
    private String loungeAccessCode;

    public VipPassenger(String name, String loungeAccessCode) {
        super(name);
        this.loungeAccessCode = loungeAccessCode;
    }

    public String getLoungeAccessCode() {
        return loungeAccessCode;
    }

    @Override
    public String toString() {
        return  "name='" + getName() + '\'' +
                ", checkedIn=" + isCheckedIn() +
                ", loungeAccessCode='" + loungeAccessCode + '\'';
    }
}
