package ProcessorSimulation.Algorithms;

import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;
import ProcessorSimulation.Simulation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FCFS implements Simulation {
    @Override
    public Statistics simulate(SimulatedProcess[] simulatedProcesses) {
        SimulatedProcess[] cloned = cloneProcesses(simulatedProcesses);

        int currentTime = 0;
        int completedProcesses = 0;
        int totalWaitingTime = 0;
        int maxWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int contextSwitchCounter = 0;

        Queue<SimulatedProcess> queue = new LinkedList<>();
        Collections.addAll(queue, cloned);

        while (!queue.isEmpty()) {
            SimulatedProcess current = queue.poll();

            currentTime = Math.max(current.getAppearedTime(), currentTime);

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
