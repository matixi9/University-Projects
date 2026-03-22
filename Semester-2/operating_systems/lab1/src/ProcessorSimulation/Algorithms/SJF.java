package ProcessorSimulation.Algorithms;

import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;
import ProcessorSimulation.Simulation;

import java.util.*;

public class SJF implements Simulation {

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

        PriorityQueue<SimulatedProcess> queue = new PriorityQueue<>(
                (p1, p2) -> p1.getLength() - p2.getLength()
        );

        while (completedProcesses < cloned.length) {
            nextProcessIndex = loadProcesses(cloned, nextProcessIndex, currentTime, queue);

            if (!queue.isEmpty()) {
                current = queue.poll();
            } else {
                if (nextProcessIndex < cloned.length) {
                    currentTime = cloned[nextProcessIndex].getAppearedTime();
                }
                continue;
            }

            current.setWaitingTime(currentTime - current.getAppearedTime());

            maxWaitingTime = Math.max(maxWaitingTime, current.getWaitingTime());

            totalWaitingTime += current.getWaitingTime();
            currentTime += current.getLength();
            totalTurnaroundTime += (currentTime - current.getAppearedTime());
            completedProcesses++;
            contextSwitchCounter++;

        }

        return new Statistics(
                totalWaitingTime / completedProcesses,
                maxWaitingTime,
                totalTurnaroundTime / completedProcesses,
                contextSwitchCounter
        );
    }
}
