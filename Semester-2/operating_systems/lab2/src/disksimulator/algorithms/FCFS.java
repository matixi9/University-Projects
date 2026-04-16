package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.List;

public class FCFS extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        for (Ticket currentTicket : queue) {
            currentTime = Math.max(currentTime, currentTicket.getAppearedTime());
            processTicket(currentTicket, waitTimes, ticketIndex);
        }
    }
}
