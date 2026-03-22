package ProcessorSimulation.Entities;

public class Statistics {
    private int averageWaitingTime;
    private int maxWaitingTime;
    private int averageTurnaroundTime;
    private int contextSwitchCounter;

    public Statistics(int averageWaitingTime, int maxWaitingTime, int averageTurnaroundTime, int contextSwitchCounter) {
        this.averageWaitingTime = averageWaitingTime;
        this.maxWaitingTime = maxWaitingTime;
        this.averageTurnaroundTime = averageTurnaroundTime;
        this.contextSwitchCounter = contextSwitchCounter;
    }

    public int getAverageWaitingTime() {return averageWaitingTime;}

    public void setAverageWaitingTime(int averageWaitingTime) {this.averageWaitingTime = averageWaitingTime;}

    public int getMaxWaitingTime() {return maxWaitingTime;}

    public void setMaxWaitingTime(int maxWaitingTime) {this.maxWaitingTime = maxWaitingTime;}

    public int getAverageTurnaroundTime() {return averageTurnaroundTime;}

    public void setAverageTurnaroundTime(int averageTurnaroundTime) {this.averageTurnaroundTime = averageTurnaroundTime;}

    public int getContextSwitchCounter() {return contextSwitchCounter;}

    public void setContextSwitchCounter(int contextSwitchCounter) {this.contextSwitchCounter = contextSwitchCounter;}
}
