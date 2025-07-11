import java.time.LocalDate;
import java.util.*;
/*
 cd Task-5_DigitalLibraryManagement
 javac LibraryManagement.java
 java LibraryManagement
 */
class LibraryMagSys {
    Scanner sc = new Scanner(System.in);
    String[] books = {"Java", "C++", "C", "Python", "HTML"};
    String[] author = {"Naman", "Bidipta", "Shreya", "Ayush", "Veer"};
    Boolean[] status = {true, true, true, true, true};
    String[] issuedTo = {"", "", "", "", ""};
    LocalDate[] issuedOn = {null, null, null, null, null};

    // public void display() {
    //     System.out.println("Books in the library:");
    //     for (int i = 0; i < books.length; i++) {
    //         String available = status[i] ? "Available" : "Issued to " + issuedTo[i] + " on " + issuedOn[i];
    //         System.out.println((i + 1) + ". " + books[i] + " by " + author[i] + " - " + available);
    //     }
    // }
    public void display() {
    System.out.println("Books available in the library:");
    for (int i = 0; i < books.length; i++) {
        if (status[i]) {
            System.out.println((i + 1) + ". " + books[i] + " by " + author[i]);
        }
    }
    System.out.println();
}

    public void addBook() {
        System.out.print("Enter book title to add: ");
        String newBook = sc.nextLine();
        System.out.print("Enter author name: ");
        String newAuthor = sc.nextLine();

        books = Arrays.copyOf(books, books.length + 1);
        author = Arrays.copyOf(author, author.length + 1);
        status = Arrays.copyOf(status, status.length + 1);
        issuedTo = Arrays.copyOf(issuedTo, issuedTo.length + 1);
        issuedOn = Arrays.copyOf(issuedOn, issuedOn.length + 1);

        books[books.length - 1] = newBook;
        author[author.length - 1] = newAuthor;
        status[status.length - 1] = true;
        issuedTo[issuedTo.length - 1] = "";
        issuedOn[issuedOn.length - 1] = null;

        System.out.println("Book added successfully!");
    }

    public void removeBook() {
        System.out.print("Enter book name to delete: ");
        String delBook = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(delBook)) {
                books = removeIndex(books, i);
                author = removeIndex(author, i);
                status = removeIndex(status, i);
                issuedTo = removeIndex(issuedTo, i);
                issuedOn = removeIndex(issuedOn, i);
                found = true;
                System.out.println("Book deleted successfully!");
                break;
            }
        }

        if (!found) System.out.println("Book not found.");
    }

    // Generic methods to remove elements from arrays
    private String[] removeIndex(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++)
            if (i != index) newArr[j++] = arr[i];
        return newArr;
    }

    private Boolean[] removeIndex(Boolean[] arr, int index) {
        Boolean[] newArr = new Boolean[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++)
            if (i != index) newArr[j++] = arr[i];
        return newArr;
    }

    private LocalDate[] removeIndex(LocalDate[] arr, int index) {
        LocalDate[] newArr = new LocalDate[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++)
            if (i != index) newArr[j++] = arr[i];
        return newArr;
    }
}

class Issue extends LibraryMagSys {
    public void issuedTo() {
        LocalDate d = LocalDate.now();
        System.out.print("Enter your name: ");
        String person = sc.nextLine();
        System.out.print("Enter book name to issue: ");
        String book = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(book)) {
                found = true;
                if (status[i]) {
                    status[i] = false;
                    issuedTo[i] = person;
                    issuedOn[i] = d;
                    System.out.println("Book '" + book + "' issued to " + person + " on " + d);
                } else {
                    System.out.println("Sorry, '" + book + "' is already issued to someone else.");
                }
                break;
            }
        }

        if (!found) System.out.println("Book not found.");
    }

    public void returnBook() {
        System.out.print("Enter the book name to return: ");
        String book = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(book)) {
                found = true;
                if (!status[i]) {
                    status[i] = true;
                    issuedTo[i] = "";
                    issuedOn[i] = null;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                break;
            }
        }

        if (!found) System.out.println("Book not found.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryMagSys l = new LibraryMagSys();
        Issue issue = new Issue();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n====== Digital Library Menu ======");
            System.out.println("1. Display books");
            System.out.println("2. Issue book");
            System.out.println("3. Add book");
            System.out.println("4. Return book");
            System.out.println("5. Delete book (Admin)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            op = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (op) {
                case 1 -> l.display();
                case 2 -> {
                    issue.issuedTo();
                    issue.display();
                }
                case 3 -> issue.addBook();
                case 4 -> issue.returnBook();
                case 5 -> issue.removeBook();
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice, try again!");
            }
        } while (op != 6);
    }
}

