package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Statistics;
import disksimulator.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSimulation implements Simulation {
    protected int currentTime = 0;
    protected int maxWaitTime = 0;
    protected int currentWaitTime = 0;
    private long totalWaitTime = 0;

    protected int switchCounter = 0;
    protected int currentBlockId = 0;
    protected int cylinderChange = 0;

    protected boolean movingUp = true;
    protected int ticketIndex = 0;
    protected int distance = 0;

    protected List<Ticket> tmpQueue = new ArrayList<>();
    protected Ticket currentTicket = null;

    //Real Time
    protected int metDeadlines = 0;
    protected int missedDeadlines = 0;

    //Standard deviation
    private double standardDeviation;
    private double arithmeticAverage;

    public abstract void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes);

    @Override
    public Statistics simulate(Disk disk, Ticket[] tickets) {
        int[] waitTimes = new int[tickets.length];
        List<Ticket> queue = new ArrayList<>(List.of(tickets));

        runAlgorithm(disk, queue, waitTimes);

        double servedRt = calculateServedRt();

        calculateStandardDeviation(tickets, waitTimes);

        return new Statistics(switchCounter,
                arithmeticAverage,
                maxWaitTime,
                standardDeviation,
                metDeadlines,
                missedDeadlines,
                servedRt
        );
    }

    protected void processTicket(Ticket ticket, int[] waitTimes, int ticketIndex) {
        cylinderChange = Math.abs(currentBlockId - ticket.getBlockId());

        currentTime += cylinderChange;
        switchCounter += cylinderChange;
        currentBlockId = ticket.getBlockId();
        currentWaitTime = currentTime - ticket.getAppearedTime();
        totalWaitTime += currentWaitTime;
        maxWaitTime = Math.max(maxWaitTime, currentWaitTime);

        waitTimes[ticketIndex] = currentWaitTime;
    }

    protected Ticket findClosestTicket() {
        int lowestDistance = Integer.MAX_VALUE;

        for (Ticket ticket : tmpQueue) {
            lowestDistance = Math.min(lowestDistance, Math.abs(currentBlockId - ticket.getBlockId()));
        }

        for (Ticket ticket : tmpQueue) {
            if (Math.abs(currentBlockId - ticket.getBlockId()) == lowestDistance) {
                currentTicket = ticket;
            }
        }
        return currentTicket;
    }

    protected Ticket findTicketInDirection(List<Ticket> queue) {
        int lowestDistance = Integer.MAX_VALUE;
        Ticket closestTicket = null;

        for (Ticket ticket : queue) {
            if (currentTime >= ticket.getAppearedTime()) {
                if ((movingUp && currentBlockId <= ticket.getBlockId())
                        || (!movingUp && currentBlockId >= ticket.getBlockId())) {
                    distance = Math.abs(currentBlockId - ticket.getBlockId());
                    if (distance < lowestDistance) {
                        lowestDistance = distance;
                        closestTicket = ticket;
                    }
                }
            }
        }
        return closestTicket;
    }

    protected void moveToEdgeOrSkipTime(List<Ticket> queue, Disk disk) {
        if (checkAnyArrived(queue)) {
            int edge = movingUp ? disk.getBlocksNumber() - 1 : 0;
            int distanceToEdge = Math.abs(currentBlockId - edge);

            currentTime += distanceToEdge;
            switchCounter += distanceToEdge;
            currentBlockId = edge;
            movingUp = !movingUp;
        } else {
            int minTime = Integer.MAX_VALUE;
            for (Ticket ticket : queue) {
                minTime = Math.min(minTime, ticket.getAppearedTime());
            }
            currentTime = minTime;
        }
    }

    protected boolean checkAnyArrived(List<Ticket> queue) {
        for (Ticket ticket : queue) {
            if (ticket.getAppearedTime() <= currentTime) {
                return true;
            }
        }
        return false;
    }

    protected void addTicketToQueue(List<Ticket> queue) {
        for (Ticket ticket : queue) {
            if (ticket.getAppearedTime() <= currentTime) {
                tmpQueue.add(ticket);
            }
        }
    }

    private void calculateStandardDeviation(Ticket[] tickets, int[] waitTimes) {
        double sumOfSquaredDifferences = 0;

        arithmeticAverage = (double) totalWaitTime / tickets.length;

        for (int time : waitTimes) {
            sumOfSquaredDifferences += Math.pow(arithmeticAverage - time, 2);
        }

        sumOfSquaredDifferences /= tickets.length;
        standardDeviation = Math.sqrt(sumOfSquaredDifferences);
    }

    private double calculateServedRt() {
        double servedRt;

        if (missedDeadlines != 0) {
            servedRt = ((double) metDeadlines / (metDeadlines + missedDeadlines)) * 100;
        } else {
            servedRt = 100;
        }
        return servedRt;
    }

    private void checkIfTicketsAppeared(List<Ticket> queue) {
        for (Ticket ticket : queue) {
            if (ticket.getAppearedTime() <= currentTime) {

            }
        }
    }
}
