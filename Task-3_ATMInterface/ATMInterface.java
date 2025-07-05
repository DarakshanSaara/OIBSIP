import java.util.*;

/*
 javac ATMInterface.java
 java ATMInterface
 */
public class ATMInterface {
    static Scanner sc = new Scanner(System.in);
    static int balance = 10000;
    static ArrayList<String> history = new ArrayList<>();

    // Display current balance in account
    public static void displayBalance(int balance) {
        System.out.println("Current Balance : Rs." + balance);
        System.out.println();
    }

    // Withdraw amount and update the balance
    public static int amountWithdrawing(int balance, int withdrawAmount) {
        System.out.println("Withdrawn Operation:");
        System.out.println("Withdrawing Amount : Rs." + withdrawAmount);
        if (balance >= withdrawAmount && withdrawAmount > 0) {
            balance -= withdrawAmount;
            System.out.println("Please collect your money.");
            displayBalance(balance);
            history.add("Withdrawn: Rs." + withdrawAmount);
        } else {
            System.out.println("Sorry! Insufficient funds or invalid amount.");
            System.out.println();
        }
        return balance;
    }

    // Deposit amount and update the balance
    public static int amountDepositing(int balance, int depositAmount) {
        System.out.println("Deposit Operation:");
        System.out.println("Depositing Amount : Rs." + depositAmount);
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Your money has been successfully deposited.");
            displayBalance(balance);
            history.add("Deposited: Rs." + depositAmount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
        return balance;
    }

    // Transfer amount to another account
    public static int amountTransferring(int balance, int transferAmount, String recipient) {
        System.out.println("Transferring Rs." + transferAmount + " to " + recipient);
        if (balance >= transferAmount && transferAmount > 0) {
            balance -= transferAmount;
            System.out.println("Transfer Successful!");
            displayBalance(balance);
            history.add("Transferred Rs." + transferAmount + " to " + recipient);
        } else {
            System.out.println("Transfer failed. Check amount or balance.");
        }
        return balance;
    }

    // Display transaction history
    public static void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    public static void main(String args[]) {
        String USER_ID = "user123";
        String USER_PIN = "1234";

        System.out.println("=== Welcome to ATM Interface ===");

        // Login
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter User ID: ");
            String id = sc.next();
            System.out.print("Enter PIN: ");
            String pin = sc.next();

            if (id.equals(USER_ID) && pin.equals(USER_PIN)) {
                System.out.println("Login successful!\n");
                break;
            } else {
                System.out.println("Invalid ID or PIN.\n");
                attempts++;
            }

            if (attempts == 3) {
                System.out.println("Too many failed attempts. Exiting...");
                return;
            }
        }

        // Operations
        while (true) {
            System.out.println("Select Operation:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmt = sc.nextInt();
                    balance = amountWithdrawing(balance, withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmt = sc.nextInt();
                    balance = amountDepositing(balance, depositAmt);
                    break;
                case 4:
                    System.out.print("Enter recipient name: ");
                    String recipient = sc.next();
                    System.out.print("Enter amount to transfer: ");
                    int transferAmt = sc.nextInt();
                    balance = amountTransferring(balance, transferAmt, recipient);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
