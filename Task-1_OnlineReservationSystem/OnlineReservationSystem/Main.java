package OnlineReservationSystem;

import java.util.Scanner;
// javac OnlineReservationSystem/*.java
// java OnlineReservationSystem.Main

public class Main {

    public static boolean login(Scanner sc) {
        String user, pass;

        System.out.println("------ LOGIN ------");
        System.out.print("Enter username: ");
        user = sc.nextLine();

        System.out.print("Enter password: ");
        pass = sc.nextLine();

        if (user.equals("saara") && pass.equals("1234")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Attempt failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attempts = 3;
        boolean loggedIn = false;

        while (attempts > 0) {
            if (login(sc)) {
                loggedIn = true;
                break;
            }
            attempts--;
            System.out.println("Remaining attempts: " + attempts);
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        ReservationService service = new ReservationService();

        while (true) {
            System.out.println("\n------ MAIN MENU ------");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    service.makeReservation();
                    break;
                case 2:
                    service.cancelReservation();
                    break;
                case 3:
                    ReservationService.viewAllBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using Online Reservation System!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

/*
 git init
git add .
git commit -m "Initial commit: Java Online Reservation System for Oasis Infobyte Internship"
git branch -M main
git remote add origin https://github.com/DarakshanSaara/OIBSIP.git
git push -u origin main

To move to a folder:
Move-Item -Path "Main.java" -Destination "Task-1_OnlineReservationSystem"
 */