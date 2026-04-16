package disksimulator.models;

public class Ticket {
    private int blockId;
    private int appearedTime;
    private int deadline;
    private boolean isRealTime;

    public Ticket(int blockId, int appearedTime, int deadline, boolean isRealTime) {
        this.blockId = blockId;
        this.appearedTime = appearedTime;
        this.deadline = deadline;
        this.isRealTime = isRealTime;
    }

    public int getBlockId() {return blockId;}

    public void setBlockId(int blockId) {this.blockId = blockId;}

    public int getAppearedTime() {return appearedTime;}

    public void setAppearedTime(int appearedTime) {this.appearedTime = appearedTime;}

    public int getDeadline() {return deadline;}

    public void setDeadline(int deadline) {this.deadline = deadline;}

    public boolean isRealTime() {return isRealTime;}

    public void setRealTime(boolean realTime) {this.isRealTime = realTime;}

    @Override
    public String toString() {
        return "Ticket{" +
                "blockId=" + blockId +
                ", appearedTime=" + appearedTime +
                ", deadline=" + deadline +
                ", isRealTime=" + isRealTime +
                '}';
    }
}
