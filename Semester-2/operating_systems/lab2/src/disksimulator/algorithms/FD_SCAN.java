package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;

import java.util.Iterator;
import java.util.List;

public class FD_SCAN extends BaseSimulation {
    @Override
    public void runAlgorithm(Disk disk, List<Ticket> queue, int[] waitTimes) {
        while (!queue.isEmpty()) {
            Ticket currentTicket = null;
            int lowestDistance = Integer.MAX_VALUE;

            Iterator<Ticket> iterator = queue.iterator();
            while (iterator.hasNext()) {
                Ticket ticket = iterator.next();

                distance = Math.abs(currentBlockId - ticket.getBlockId());

                if (ticket.isRealTime() && ticket.getAppearedTime() <= currentTime && currentTime + distance > ticket.getDeadline()) {
                    iterator.remove();
                    missedDeadlines++;
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            int lowestDeadline = Integer.MAX_VALUE;
            for (Ticket ticket : queue) {
                if (ticket.isRealTime() && ticket.getAppearedTime() <= currentTime) {
                    lowestDeadline = Math.min(lowestDeadline, ticket.getDeadline());
                }
            }

            for (Ticket ticket : queue) {
                if (ticket.isRealTime() && lowestDeadline == ticket.getDeadline() && ticket.getAppearedTime() <= currentTime) {
                    movingUp = ticket.getBlockId() >= currentBlockId;
                }
            }

            currentTicket = findTicketInDirection(queue);

            if (currentTicket == null) {
                moveToEdgeOrSkipTime(queue, disk);
                continue;
            }

            queue.remove(currentTicket);

            processTicket(currentTicket, waitTimes, ticketIndex);
            ticketIndex++;

            if (currentTicket.isRealTime()) {
                metDeadlines++;
            }
        }
    }
}
