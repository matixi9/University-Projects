package ProcessorSimulation.Algorithms;

import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;
import ProcessorSimulation.Simulation;

import java.util.*;

public class SJFw implements Simulation {

    @Override
    public Statistics simulate(SimulatedProcess[] simulatedProcesses) {
        SimulatedProcess[] cloned = cloneProcesses(simulatedProcesses);

        int currentTime = 0;
        int completedProcesses = 0;
        int totalWaitingTime = 0;
        int nextProcessIndex = 0;
        int maxWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int contextSwitchCounter = 0;

        SimulatedProcess current = null;
        SimulatedProcess previous = null;

        PriorityQueue<SimulatedProcess> queue = new PriorityQueue<>(
                (p1, p2) -> p1.getTimeToBeServed() - p2.getTimeToBeServed()
        );

        while (completedProcesses < cloned.length) {
            nextProcessIndex = loadProcesses(cloned, nextProcessIndex, currentTime, queue);

            if (!queue.isEmpty()) {
                current = queue.poll();
            } else {
                currentTime++;
                continue;
            }

            if (current != previous) {
                contextSwitchCounter++;
                previous = current;
            }

            if (current.getTimeToBeServed() <= 1) {
                currentTime += current.getTimeToBeServed();
                current.setWaitingTime(currentTime - current.getAppearedTime() - current.getLength());

                maxWaitingTime = Math.max(maxWaitingTime, current.getWaitingTime());

                totalWaitingTime += current.getWaitingTime();
                totalTurnaroundTime += (currentTime - current.getAppearedTime());
                completedProcesses++;
            } else {
                current.setTimeToBeServed(current.getTimeToBeServed() - 1);
                currentTime++;
                queue.add(current);
            }
        }

        return new Statistics(
                totalWaitingTime / completedProcesses,
                maxWaitingTime,
                totalTurnaroundTime / completedProcesses,
                contextSwitchCounter
        );
    }
}
