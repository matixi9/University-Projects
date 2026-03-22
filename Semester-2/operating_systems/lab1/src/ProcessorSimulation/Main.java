package ProcessorSimulation;

import ProcessorSimulation.Algorithms.FCFS;
import ProcessorSimulation.Algorithms.RR;
import ProcessorSimulation.Algorithms.SJF;
import ProcessorSimulation.Algorithms.SJFw;
import ProcessorSimulation.Entities.SimulatedProcess;
import ProcessorSimulation.Entities.Statistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of tests: ");
        int testsNumber = sc.nextInt();
        System.out.println("Enter number of processes per test: ");
        int processesNumber = sc.nextInt();

        SimulatedProcess[][] generatedTests = generator.generateTests(testsNumber, processesNumber);

        double[][] allResults = testAlgorithms(generatedTests, testsNumber);

        printResultsTable(testsNumber, allResults);
    }

    public static void printResultsTable(int testsNumber, double[][] results) {
        System.out.println("\n===============================================================================");
        System.out.println(" SIMULATION RESULTS (Averages from " + testsNumber + " tests)");
        System.out.println("===============================================================================");
        System.out.printf("%-18s | %-12s | %-12s | %-15s | %-15s%n",
                "Algorithm", "Avg Wait", "Max Wait", "Turnaround Time", "Context Switch");
        System.out.println("-------------------------------------------------------------------------------");

        String[] names = {"FCFS", "SJF", "SJFw", "RR"};

        for (int i = 0; i < names.length; i++) {
            printAlgorithmRow(names[i], results[i], testsNumber);
        }

        System.out.println("===============================================================================");
    }

    private static void printAlgorithmRow(String name, double[] stats, int testsNumber) {
        System.out.printf("%-18s | %-12.2f | %-12.2f | %-15.2f | %-15.2f%n",
                name,
                stats[0] / testsNumber,
                stats[1] / testsNumber,
                stats[2] / testsNumber,
                stats[3] / testsNumber);
    }

    public static double[][] testAlgorithms(SimulatedProcess[][] tests, int testsNumber) {
        Simulation[] algorithms = {new FCFS(), new SJF(), new SJFw(), new RR(4)};
        double[][] results = new double[algorithms.length][4];

        for (int i = 0; i < testsNumber; i++) {
            SimulatedProcess[] singleTest = tests[i];

            for (int algIndex = 0; algIndex < algorithms.length; algIndex++) {
                Statistics stats = algorithms[algIndex].simulate(singleTest);

                results[algIndex][0] += stats.getAverageWaitingTime();
                results[algIndex][1] += stats.getMaxWaitingTime();
                results[algIndex][2] += stats.getAverageTurnaroundTime();
                results[algIndex][3] += stats.getContextSwitchCounter();
            }
        }
        return results;
    }
}
