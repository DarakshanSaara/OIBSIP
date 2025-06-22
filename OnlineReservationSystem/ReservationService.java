package OnlineReservationSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReservationService {
    private final ArrayList<Reservation> bookings = new ArrayList<>();
    private final HashMap<String, String> data = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public ReservationService() {
        data.put("1001", "Shatabdi Express");
        data.put("1002", "Rajdhani Express");
        data.put("1003", "Duronto Express");
    }

    // Method to book a reservation
    public void makeReservation() {
        System.out.println("\n--- Make a Reservation ---");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        String trainNo = sc.nextLine();

        String trainName = data.getOrDefault(trainNo, "Unknown Train");
        if (trainName.equals("Unknown Train")) {
            System.out.println("Invalid Train Number. Reservation failed.");
            return;
        }

        System.out.print("Enter Class Type (e.g. Sleeper/AC/First): ");
        String classType = sc.nextLine();

        System.out.print("Enter Date of Journey (DD-MM-YYYY): ");
        String dateOfJourney = sc.nextLine();

        System.out.print("Enter Departure Station: ");
        String from = sc.nextLine();

        System.out.print("Enter Destination Station: ");
        String to = sc.nextLine();

        String pnr = generatePNR();

        Reservation res = new Reservation(name, trainNo, trainName, classType, dateOfJourney, from, to, pnr);
        bookings.add(res);

        System.out.println("Reservation Successful! Your PNR: " + pnr);
        res.display();
        saveBookingToFile(res);
    }

    // Method to cancel reservation by PNR
    public void cancelReservation() {
    System.out.print("\nEnter PNR to cancel: ");
    String pnrToCancel = sc.nextLine();

    boolean found = false;
    Reservation toRemove = null;

    for (Reservation res : bookings) {
        if (res.getPNR().equals(pnrToCancel)) {
            found = true;
            System.out.println("Reservation Found:");
            res.display();
            System.out.print("Are you sure you want to cancel? (yes/no): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                toRemove = res; // mark for removal after loop
            } else {
                System.out.println("Cancellation Aborted.");
            }
            break;
        }
    }

    if (found && toRemove != null) {
        bookings.remove(toRemove);
        System.out.println("Reservation Cancelled Successfully.");
        updateBookingsFile(); // <-- new helper method to update bookings.txt
    } else if (!found) {
        System.out.println("No reservation found with PNR: " + pnrToCancel);
    }
}

    // Simple random PNR generator
    private String generatePNR() {
        return "PNR" + new Random().nextInt(90000) + 10000;
    }

    public static void saveBookingToFile(Reservation res) {
    try {
        FileWriter fw = new FileWriter("bookings.txt", true); // true = append mode
        fw.write("PNR: " + res.getPNR() + "\n");
        fw.write("Name: " + res.getName() + "\n");
        fw.write("Train No: " + res.getTrainNo() + "\n");
        fw.write("Train Name: " + res.getTrainName() + "\n");
        fw.write("Class Type: " + res.getClassType() + "\n");
        fw.write("From: " + res.getFrom() + "\n");
        fw.write("To: " + res.getTo() + "\n");
        fw.write("Date of Journey: " + res.getDateOfJourney() + "\n");
        fw.write("--------------------------------------------------\n");
        fw.close();
    } catch (IOException e) {
        System.out.println("Error saving booking to file: " + e.getMessage());
    }
}

public static void viewAllBookings() {
    try {
        File file = new File("bookings.txt");
        if (!file.exists() || file.length() == 0) {
            System.out.println("No bookings found.");
            return;
        }

        Scanner reader = new Scanner(file);
        System.out.println("\n--- All Bookings ---\n");
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error reading bookings: " + e.getMessage());
    }
}

private void updateBookingsFile() {
    try {
        FileWriter writer = new FileWriter("bookings.txt", false); // overwrite
        for (Reservation res : bookings) {
            writer.write(res.toString() + "\n");
        }
        writer.close();
    } catch (IOException e) {
        System.out.println("Error updating bookings file: " + e.getMessage());
    }
}

}

