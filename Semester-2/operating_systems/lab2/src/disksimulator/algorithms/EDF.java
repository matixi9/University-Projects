package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.*;

public class EDF extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        while (!queue.isEmpty()) {
            Ticket currentTicket = null;

            addTicketToQueue(queue);

            int minTime = Integer.MAX_VALUE;
            if (!tmpQueue.isEmpty()) {
                for (Ticket ticket : tmpQueue) {
                    if (ticket.isRealTime()) {
                        minTime = Math.min(minTime, ticket.getDeadline());
                    }
                }

                if (minTime != Integer.MAX_VALUE) {
                    for (Ticket ticket : tmpQueue) {
                        if (ticket.isRealTime() && ticket.getDeadline() == minTime) {
                            currentTicket = ticket;
                            break;
                        }
                    }
                }
            } else {

                for (Ticket ticket : queue) {
                    minTime = Math.min(ticket.getAppearedTime(), minTime);
                }
                currentTime = minTime;
                continue;
            }

            if (currentTicket == null) {
                currentTicket = findClosestTicket();
            }

            queue.remove(currentTicket);
            tmpQueue.clear();

            processTicket(currentTicket, waitTimes, ticketIndex);
            ticketIndex++;

            if (currentTicket.isRealTime()) {
                if (currentTime <= currentTicket.getDeadline()) {
                    metDeadlines++;
                } else {
                    missedDeadlines++;
                }
            }
        }
    }
}
