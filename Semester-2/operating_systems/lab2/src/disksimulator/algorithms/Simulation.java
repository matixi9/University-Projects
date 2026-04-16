package disksimulator.algorithms;

import disksimulator.models.Disk;
import disksimulator.models.Statistics;
import disksimulator.models.Ticket;

public interface Simulation {
    Statistics simulate(Disk disk, Ticket[] tickets);
}
