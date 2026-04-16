package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.List;

public class SCAN extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        while (!queue.isEmpty()) {
            Ticket currentTicket = findTicketInDirection(queue);

            if (currentTicket == null) {
                moveToEdgeOrSkipTime(queue, disk);
                continue;
            }

            queue.remove(currentTicket);
            processTicket(currentTicket, waitTimes, ticketIndex);
            ticketIndex++;
        }
    }
}
