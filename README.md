# University Projects

This repository is a collection of academic projects, laboratories, and programming assignments completed during my university studies. It mainly focuses on Java, demonstrating the development of skills – from the basics of object-oriented programming to more complex topics like system simulations.

## 🗂 Repository Structure

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
    * **FCFS** (First-Come, First-Served)
    * **RR** (Round Robin)
    * **SJF** (Shortest Job First - non-preemptive)
    * **SJFw** (Shortest Remaining Time First - preemptive SJF)

  The project also includes a data generator (`DataGenerator`) and a statistics collection system (`Statistics`).

## 🛠 Technologies
The following technologies and tools were used in the repository:
* **Language:** Java (JDK 11+)
* **Dependency Management:** Maven (in newer labs, e.g., Lab 10 and Lab 11)
* **Libraries and frameworks:** JavaFX (GUI), JUnit (Testing)
* **IDE:** IntelliJ IDEA

## 🚀 How to run the projects
Most of the smaller projects from the first semester are standard console applications that can be run by executing the `main` method in the selected class (e.g., `Main.java`).

For projects using Maven (e.g., `Lab 10` and `Lab 11` from the first semester):
1. Navigate to the folder with the corresponding `pom.xml` (e.g., `cd "Semester-1/object-oriented programming/lab10/PSiO_Lab_10"`).
2. Compile the project using Maven:
   ```bash
   ./mvnw clean install