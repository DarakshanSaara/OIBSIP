import java.util.*;
/*
 cd Task-4_OnlineExamination
 javac OnlineExaminationSystem.java
 java OnlineExaminationSystem
 */
public class OnlineExaminationSystem {
    static Scanner sc = new Scanner(System.in);
    static String username = "user";
    static String password = "pass123";
    static boolean isLoggedIn = false;
    static int score = 0;
    static int timerSeconds = 60; // 1 min timer

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Online Examination System ===");
            if (!isLoggedIn) {
                System.out.println("1. Login\n2. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (choice == 1) login();
                else break;
            } else {
                System.out.println("1. Update Profile\n2. Take Test\n3. Logout");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: updateProfile(); break;
                    case 2: takeTest(); break;
                    case 3: logout(); break;
                }
            }
        }
    }

    static void login() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login successful!");
            isLoggedIn = true;
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    static void updateProfile() {
        System.out.print("Enter new username: ");
        username = sc.nextLine();
        System.out.print("Enter new password: ");
        password = sc.nextLine();
        System.out.println("Profile updated successfully.");
    }

    static void takeTest() {
        System.out.println("\nStarting test (Auto-submit in 60 seconds)...");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Auto-submitting...");
                System.out.println("Your Score: " + score + "/3");
                score = 0;
                timer.cancel();
            }
        }, timerSeconds * 1000);

        System.out.println("Q1. Java is:\n1. Language\n2. OS\n3. Compiler\n4. Editor");
        int ans1 = sc.nextInt();
        if (ans1 == 1) score++;

        System.out.println("Q2. 5 + 7 = ?\n1. 10\n2. 11\n3. 12\n4. 13");
        int ans2 = sc.nextInt();
        if (ans2 == 3) score++;

        System.out.println("Q3. OOPs stands for:\n1. Object Oriented Programming\n2. Object Operating Process\n3. Oriented Object Platform\n4. None");
        int ans3 = sc.nextInt();
        if (ans3 == 1) score++;

        System.out.println("You submitted the test.");
        System.out.println("Your Score: " + score + "/3");
        score = 0;
        timer.cancel();
    }

    static void logout() {
        isLoggedIn = false;
        System.out.println("Logged out successfully.");
    }
}
