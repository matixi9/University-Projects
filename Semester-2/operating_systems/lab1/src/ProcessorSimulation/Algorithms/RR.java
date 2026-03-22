package ProcessorSimulation.Algorithms;

import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;
import ProcessorSimulation.Simulation;

import java.util.*;

public class RR implements Simulation {
    private final int timeQuantum;

    public RR(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    @Override
    public Statistics simulate(SimulatedProcess[] simulatedProcesses) {
        SimulatedProcess[] cloned = cloneProcesses(simulatedProcesses);

        int currentTime = 0;
        int completedProcesses = 0;
        int nextProcessIndex = 0;

        int totalWaitingTime = 0;
        int maxWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int contextSwitchCounter = 0;

        Queue<SimulatedProcess> queue = new LinkedList<SimulatedProcess>();

        while (completedProcesses < cloned.length) {
            nextProcessIndex = loadProcesses(cloned, nextProcessIndex, currentTime, queue);

            if (queue.isEmpty()) {
                currentTime++;
                continue;
            }

            SimulatedProcess current = queue.poll();
            contextSwitchCounter++;

            if (current.getTimeToBeServed() <= timeQuantum) {
                currentTime += current.getTimeToBeServed();

                int localTurnaroundTime = currentTime - current.getAppearedTime();
                int localWaitingTime = localTurnaroundTime - current.getLength();

                current.setWaitingTime(localWaitingTime);
                maxWaitingTime = Math.max(maxWaitingTime, current.getWaitingTime());


                totalWaitingTime += current.getWaitingTime();
                totalTurnaroundTime += localTurnaroundTime;
                completedProcesses++;

            } else {
                currentTime += timeQuantum;
                current.setTimeToBeServed(current.getTimeToBeServed() - timeQuantum);

                while (nextProcessIndex < cloned.length && cloned[nextProcessIndex].getAppearedTime() <= currentTime) {
                    queue.add(cloned[nextProcessIndex]);
                    nextProcessIndex++;
                }

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