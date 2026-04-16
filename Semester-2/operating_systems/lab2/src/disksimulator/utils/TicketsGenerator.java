package disksimulator.utils;

import disksimulator.models.Disk;
import disksimulator.models.Ticket;
import java.util.Random;

public class TicketsGenerator {
    public Ticket[] generateTickets(int ticketsNumber, Disk disk) {
        int previousAppearedTime = 0;
        int currentAppearedTime;

        if (ticketsNumber < 0) {
            throw new IllegalArgumentException("Wrong tickets number");
        }

        Ticket[] tickets = new Ticket[ticketsNumber];
        Random rand = new Random();

        for (int i = 0; i < ticketsNumber; i++) {
            currentAppearedTime = previousAppearedTime + rand.nextInt(10);
            tickets[i] = new Ticket(
                    rand.nextInt(disk.getBlocksNumber()),
                    currentAppearedTime,
                    //Can modify to change when deadline is set
                    //Has to be big enough to overcome time to change between blocks
                    currentAppearedTime + rand.nextInt(2000) + 5000,
                    rand.nextBoolean()
            );
            previousAppearedTime = currentAppearedTime;
        }
        return tickets;
    }
}
