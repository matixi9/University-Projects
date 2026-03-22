package ProcessorSimulation;

import ProcessorSimulation.Entities.SimulatedProcess;

import java.util.Random;

public class DataGenerator {
    private final Random rand = new Random();

    public SimulatedProcess[][] generateTests(int testsNumber, int processesNumber) {
        SimulatedProcess[][] tests = new SimulatedProcess[testsNumber][processesNumber];

        for (int i = 0; i < testsNumber; i++) {
            tests[i] = generateProcesses(processesNumber);
        }
        return tests;
    }

    private SimulatedProcess[] generateProcesses(int processesNumber) {
        SimulatedProcess[] simulatedProcesses = new SimulatedProcess[processesNumber];
        int currentAppearedTime = 0;

        for (int processId = 0; processId < processesNumber; processId++) {
            int randomLength = rand.nextInt(10) + 1;
            currentAppearedTime += rand.nextInt(6);

            simulatedProcesses[processId] = new SimulatedProcess(processId, randomLength, randomLength, currentAppearedTime, 0);
        }

        return simulatedProcesses;
    }
}
