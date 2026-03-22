package ProcessorSimulation.Entities;

public class SimulatedProcess {
    private int ID;
    private int length;
    private int timeToBeServed;
    private int appearedTime;
    private int waitingTime;

    public SimulatedProcess(int ID, int length, int timeToBeServed, int appearedTime, int waitingTime) {
        this.ID = ID;
        this.length = length;
        this.timeToBeServed = timeToBeServed;
        this.appearedTime = appearedTime;
        this.waitingTime = waitingTime;
    }

    public SimulatedProcess cloneProcess() {
        return new SimulatedProcess(this.ID, this.length, this.timeToBeServed, this.appearedTime, this.waitingTime);
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public int getLength() {return length;}

    public void setLength(int length) {this.length = length;}

    public int getAppearedTime() {return appearedTime;}

    public void setAppearedTime(int appearedTime) {this.appearedTime = appearedTime;}

    public int getWaitingTime() {return waitingTime;}

    public void setWaitingTime(int waitingTime) {this.waitingTime = waitingTime;}

    public int getTimeToBeServed() {return timeToBeServed;}

    public void setTimeToBeServed(int timeToBeServed) {this.timeToBeServed = timeToBeServed;}

    @Override
    public String toString() {
        return ID + " " + length + " " + timeToBeServed + " " + appearedTime + " " + waitingTime;
    }
}
