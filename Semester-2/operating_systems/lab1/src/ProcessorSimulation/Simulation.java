package ProcessorSimulation;

import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;

import java.util.Queue;

public interface Simulation {
    Statistics simulate(SimulatedProcess[] simulatedProcesses);

    default SimulatedProcess[] cloneProcesses(SimulatedProcess[] simulatedProcesses) {
        SimulatedProcess[] cloned = new SimulatedProcess[simulatedProcesses.length];
        for (int i = 0; i < simulatedProcesses.length; i++) {
            cloned[i] = simulatedProcesses[i].cloneProcess();
        }
        return cloned;
    }

    default int loadProcesses(SimulatedProcess[] cloned, int nextIdx, int time, Queue<SimulatedProcess> q) {
        while (nextIdx < cloned.length && cloned[nextIdx].getAppearedTime() <= time) {
            q.add(cloned[nextIdx]);
            nextIdx++;
        }
        return nextIdx;
    }
}
