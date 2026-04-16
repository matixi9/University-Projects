package disksimulator.models;

public class Disk {
    private int blocksNumber;

    public Disk(int blocksNumber) {
        this.blocksNumber = blocksNumber;
    }

    public int getBlocksNumber() {return blocksNumber;}

    public void setBlocksNumber(int blocksNumber) {this.blocksNumber = blocksNumber;}

    @Override
    public String toString() {
        return "Disk{" +
                "blocksNumber=" + blocksNumber +
                '}';
    }
}
