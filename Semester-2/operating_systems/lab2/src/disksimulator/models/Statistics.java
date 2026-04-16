package disksimulator.models;

public class Statistics {
    private int switchCounter;
    private double avgWaitTime;
    private int maxWaitTime;
    private double standardDeviation;
    private int metDeadlines;
    private int missedDeadlines;
    private double servedRt;

    public Statistics(int switchCounter, double avgWaitTime, int maxWaitTime, double standardDeviation, int metDeadlines, int missedDeadlines, double servedRt) {
        this.switchCounter = switchCounter;
        this.avgWaitTime = avgWaitTime;
        this.maxWaitTime = maxWaitTime;
        this.standardDeviation = standardDeviation;
        this.metDeadlines = metDeadlines;
        this.missedDeadlines = missedDeadlines;
        this.servedRt = servedRt;
    }

    public int getSwitchCounter() {
        return switchCounter;
    }

    public void setSwitchCounter(int switchCounter) {
        this.switchCounter = switchCounter;
    }

    public double getAvgWaitTime() {
        return avgWaitTime;
    }

    public void setAvgWaitTime(double avgWaitTime) {
        this.avgWaitTime = avgWaitTime;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public int getMetDeadlines() {
        return metDeadlines;
    }

    public void setMetDeadlines(int metDeadlines) {
        this.metDeadlines = metDeadlines;
    }

    public int getMissedDeadlines() {
        return missedDeadlines;
    }

    public void setMissedDeadlines(int missedDeadlines) {
        this.missedDeadlines = missedDeadlines;
    }

    public double getServedRt() {
        return servedRt;
    }

    public void setServedRt(double servedRt) {
        this.servedRt = servedRt;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "switchCounter=" + switchCounter +
                ", avgWaitTime=" + avgWaitTime +
                ", maxWaitTime=" + maxWaitTime +
                ", standardDeviation=" + standardDeviation +
                ", metDeadlines=" + metDeadlines +
                ", missedDeadlines=" + missedDeadlines +
                ", servedRt=" + servedRt +
                '}';
    }
}
