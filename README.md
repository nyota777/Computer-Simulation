# 🏦 Bank Queue Simulation - Java GUI Project

This project simulates a **bank queue system** where customers arrive randomly (uniformly distributed) and are served one at a time by a single server. It also features a **graphical user interface (GUI)** using Java Swing and **charts** for visualization using JFreeChart.

---

## 🚀 Features

- Simulates 100 customers
- Random **arrival times** between 1 to 8 minutes
- Random **service times** between 1 to 6 minutes
- Calculates:
    - Waiting time
    - Idle time
    - Average waiting time
    - Total idle time
- Displays results in a table
- Visualizes:
    - Waiting time per customer
    - Idle time per customer

---

## 🛠️ Technologies Used

- Java 8+
- Swing (for GUI)
- JFreeChart (for data visualization)

---

## 📁 Project Structure


---

## ▶️ How to Run the Project

1. **Open IntelliJ IDEA**
2. Create or import a Java project
3. Add the `.java` files inside `src/com/bank`
4. Add the JFreeChart JAR files (`jfreechart-1.5.3.jar` and `jcommon-1.0.24.jar`) to the project:
    - Go to **File > Project Structure > Libraries > Add**
5. Run the program using the `Main.java` class

---

## 📊 Output

- A **Swing window** titled "Bank Queue Simulation"
- Table with:
    - ID, Arrival Time, Service Time, Start Time, End Time, Wait Time, Idle Time
- Bottom labels showing:
    - Average wait time
    - Total idle time
- A **chart window** that opens with:
    - Bar chart of customer waiting times
    - Bar chart of server idle times

---

## 📚 Concepts Demonstrated

- Discrete Event Simulation
- Uniform Random Distribution
- Java Swing GUI development
- Chart rendering with JFreeChart
- Performance metric analysis (wait time, idle time)

---

## 📌 Author

Arthur Nyota  
Strathmore University
Email
arthur.nyota@strathmore.edu
---

