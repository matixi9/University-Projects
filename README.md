# University Projects

This repository is a collection of academic projects, laboratories, and programming assignments completed during my university studies. It mainly focuses on Java, demonstrating the development of skills – from the basics of object-oriented programming to more complex topics like system simulations.

---

## Repository Structure

The projects are divided into semesters and specific courses:

### Semester 1: Object-Oriented Programming
This directory contains a series of laboratories (Lists 1-11) introducing and developing the concepts of the object-oriented paradigm in Java.
* **Lab 1-3:** Syntax basics, unit converters (e.g., `KonwerterTemperatur`), simple I/O operations.
* **Lab 4-5:** Class modeling, encapsulation, composition (e.g., booking systems, device management, admin panels, Data Center).
* **Lab 6-7:** Inheritance, interfaces, and polymorphism (vehicle models, payment gateways like BLIK, PayPal, animal structure simulation).
* **Lab 8-9:** File handling (CSV, JSON read/write, logs), exception handling.
* **Lab 10:** Graphical User Interface (GUI) applications using **JavaFX** (a To-Do app, based on Maven).
* **Lab 11:** Unit testing (including `CalculatorTest`, `UserTest`) and creating custom exceptions (`DivisionByZeroException`).
* **Lab 12 (Final Project):** A car insurance calculator built as a REST API using **Spring Boot** and the Strategy design pattern. Due to its size and complexity, this project is hosted in a separate repository. Check it out here: **[insurance-calculator](https://github.com/matixi9/insurance-calculator)**.

### Semester 2: Operating Systems
* **Lab 1 - CPU Simulation:** A Java project simulating the operation of various CPU scheduling algorithms. The implemented algorithms are:
    * **FCFS** (First Come First Served)
    * **RR** (Round Robin)
    * **SJF** (Shortest Job First - non-preemptive)
    * **SJFw** (Shortest Remaining Time First - preemptive SJF)

  The project also includes a data generator (`DataGenerator`) and a statistics collection system (`Statistics`).


* **Lab 2 - Disk Simulator**
A disk drive simulation designed to compare the performance of various disk scheduling algorithms. The program simulates handling track requests and calculates the total head movement (seek distance). Used algorithms:
  * **FCFS** (First-Come, First-Served): Processes requests in the exact order they arrive.
  * **SSTF** (Shortest Seek Time First): Selects the request closest to the current head position to minimize seek time.
  * **SCAN** (Elevator Algorithm): The head moves in one direction, servicing all requests until it reaches the end of the disk, then reverses direction.
  * **C-SCAN** (Circular SCAN): Similar to SCAN, but when the head reaches the end, it immediately returns to the beginning without servicing requests on the return trip.
  * **EDF** (Earliest Deadline First): A real-time algorithm that prioritizes requests based on their specific deadlines.
  * **FD-SCAN** (Feasible Deadline SCAN): A variation of SCAN that considers deadlines, moving towards the nearest request that can still be serviced before its deadline expires.

#### Project Structure:
- `src/disksimulator/algorithms/`: Core implementations of the scheduling strategies.
- `src/disksimulator/models/`: Data models including `Disk`, `Ticket` (request), and `Statistics`.
- `src/disksimulator/utils/`: Utility classes like `TicketsGenerator` for creating random test scenarios.
- `Main.java`: The entry point of the application, where simulation parameters (disk size, number of requests) are configured.

#### Usage:
The simulation defaults to 500 requests on a disk with 200 blocks. Results are outputted to the console, showing the total head displacement for each algorithm, allowing for direct efficiency comparison.

---

## Technologies
The following technologies and tools were used in the repository:
* **Language:** Java (JDK 11+)
* **Dependency Management:** Maven (in newer labs, e.g., Lab 10 and Lab 11)
* **Libraries and frameworks:** JavaFX (GUI), JUnit (Testing)
* **IDE:** IntelliJ IDEA

---

## How to run the projects
Most of the smaller projects from the first semester are standard console applications that can be run by executing the `main` method in the selected class (e.g., `Main.java`).

For projects using Maven (e.g., `Lab 10` and `Lab 11` from the first semester):
1. Navigate to the folder with the corresponding `pom.xml` (e.g., `cd "Semester-1/object-oriented programming/lab10/PSiO_Lab_10"`).
2. Compile the project using Maven:
   ```bash
   ./mvnw clean install