# 🧾 Online Reservation System - Java Console Project

This is a **Java-based Online Reservation System** built as part of the **AICTE Oasis Infobyte Internship**. It allows users to reserve train tickets, cancel bookings, and view all reservations using a terminal-based interface.

## 🚀 Features

- ✅ **User Login System**
  - Secure login with username and password (hardcoded for demo).
  
- 🚆 **Train Ticket Reservation**
  - Choose from a list of predefined trains.
  - Fill in details: passenger name, travel date, class, source & destination.

- ❌ **Ticket Cancellation**
  - Cancel booking using the PNR number.
  
- 📂 **File Storage**
  - All confirmed bookings are saved to a `bookings.txt` file.
  
- 📋 **View Bookings**
  - Users can view all reservations stored in the file.

---

## 💻 Technologies Used

- Language: **Java**
- IDE: IntelliJ / VS Code
- File Handling: `FileWriter`, `Scanner`
- Java Concepts Used:
  - Classes & Objects
  - File I/O
  - Loops and Conditionals
  - Scanner for input

---

## 📁 Project Structure

OnlineReservationSystem/
├── Main.java                   ✔️ Main logic and menu
├── Reservation.java            ✔️ Reservation model class
├── ReservationService.java     ✔️ Booking/cancellation/viewing logic
├── Main.class                  ✔️ Compiled bytecode (ok to include)
├── Reservation.class           ✔️ Compiled class
├── ReservationService.class    ✔️ Compiled class
├── bookings.txt                ✔️ Stores saved bookings
├── README.md                   ✔️ Documentation for GitHub


---

## 🧪 How to Run

1. **Compile all files**:
   ```bash
   javac -encoding UTF-8 OnlineReservationSystem/*.java

2. **Run the program**
   java OnlineReservationSystem.Main

---
## 🧑‍💻 Demo Credentials

Username: saara
Password: 1234

---

## 🎯 Future Improvements (optional)

- Add GUI using JavaFX/Swing
- Store data in a database instead of text file
- Register new users dynamically
- Dynamic train list

---

## 📜 Internship Task Details

Domain: Java Development
Batch: June 2025
Task: Create an Online Reservation System with core Java features
Submitted to: Oasis Infobyte

---

## 📌 Author

Saara Darakshan
B.Tech CSE Student at LNCT&S, Bhopal
LinkedIn: http://www.linkedin.com/in/saara-darakshan-877238322