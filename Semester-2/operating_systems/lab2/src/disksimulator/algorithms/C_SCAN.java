package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.List;

public class C_SCAN extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        while (!queue.isEmpty()) {
            Ticket currentTicket = null;
            int lowestDistance = Integer.MAX_VALUE;

            for (Ticket ticket : queue) {
                if (currentTime >= ticket.getAppearedTime() && currentBlockId <= ticket.getBlockId()) {
                    distance = Math.abs(currentBlockId - ticket.getBlockId());
                    if (distance < lowestDistance) {
                        lowestDistance = distance;
                        currentTicket = ticket;
                    }
                }
            }

            if (currentTicket == null) {
                if (checkAnyArrived(queue)) {
                    int edge = disk.getBlocksNumber() - 1;
                    int distanceToEdge = Math.abs(currentBlockId - edge);

                    currentTime += distanceToEdge + disk.getBlocksNumber() - 1;
                    switchCounter += distanceToEdge + disk.getBlocksNumber() - 1;
                    currentBlockId = 0;

                } else {
                    int minTime = Integer.MAX_VALUE;
                    for (Ticket ticket : queue) {
                        minTime = Math.min(minTime, ticket.getAppearedTime());
                    }
                    currentTime = minTime;
                }
                continue;
            }

            queue.remove(currentTicket);

            processTicket(currentTicket, waitTimes, ticketIndex);
            ticketIndex++;
        }
    }
}
