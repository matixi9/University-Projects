package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.List;

public class SSTF extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        while (!queue.isEmpty()) {
            addTicketToQueue(queue);

            if (!tmpQueue.isEmpty()) {
                findClosestTicket();
            } else {
                int minTime = Integer.MAX_VALUE;

                for (Ticket ticket : queue) {
                    minTime = Math.min(ticket.getAppearedTime(), minTime);
                }
                currentTime = minTime;
                continue;
            }

            queue.remove(currentTicket);
            tmpQueue.clear();

            processTicket(currentTicket, waitTimes, ticketIndex);
        }
    }
}

