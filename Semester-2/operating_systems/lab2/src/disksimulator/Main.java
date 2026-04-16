package disksimulator;

import disksimulator.algorithms.*;
import disksimulator.models.Disk;
import disksimulator.models.Statistics;
import disksimulator.models.Ticket;
import disksimulator.utils.TicketsGenerator;

public class Main {
    public static void main(String[] args) {
        int ticketsNumber = 500;
        int blocksNumber = 200;

        Disk disk = new Disk(blocksNumber);

        TicketsGenerator ticketsGenerator = new TicketsGenerator();
        Ticket[] tickets = ticketsGenerator.generateTickets(ticketsNumber, disk);

        FCFS fcfs = new FCFS();
        SSTF sstf = new SSTF();
        SCAN scan = new SCAN();
        C_SCAN cscan = new C_SCAN();
        EDF edf = new EDF();
        FD_SCAN fdscan = new FD_SCAN();

        Simulation[] simulations = new Simulation[6];
        simulations[0] = fcfs;
        simulations[1] = sstf;
        simulations[2] = scan;
        simulations[3] = cscan;
        simulations[4] = edf;
        simulations[5] = fdscan;

        String[] algorithms = {"FCFS", "SSTF", "SCAN", "C_SCAN", "EDF", "FD_SCAN"};

        printStatistics(simulations, disk, tickets, algorithms);
    }

    public static void printStatistics(Simulation[] simulations, Disk disk, Ticket[] tickets, String[] algorithms) {

        System.out.println("======================================================= Simulation Results for: " + tickets.length + " tickets ======================================================");
        System.out.printf("| %-10s | %-14s | %-13s | %-13s | %-18s | %-15s | %-16s | %-10s |",
                "Algorithm",
                "Switch Counter",
                "Avg Wait Time",
                "Max Wait Time",
                "Standard Deviation",
                "Met Deadlines",
                "Missed Deadlines",
                "Served Rt"
        );

        System.out.println();

        int i = 0;

        for (Simulation sim : simulations) {
            printSingleStatistics(sim, disk, tickets, algorithms[i]);
            i++;
        }
    }

    private static void printSingleStatistics(Simulation simulation, Disk disk, Ticket[] tickets, String algorithm) {
        Statistics statistics = simulation.simulate(disk, tickets);

        System.out.printf("| %-10s | %-14d | %-13.2f | %-13d | %-18.2f | %-15d | %-16d | %-10.2f |",
                algorithm,
                statistics.getSwitchCounter(),
                statistics.getAvgWaitTime(),
                statistics.getMaxWaitTime(),
                statistics.getStandardDeviation(),
                statistics.getMetDeadlines(),
                statistics.getMissedDeadlines(),
                statistics.getServedRt()
        );
        System.out.println();
    }
}
