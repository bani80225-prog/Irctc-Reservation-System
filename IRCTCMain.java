package project_1;

import java.util.Scanner;

/**
 * IRCTCMain — Entry point for the Next-Gen Railway Reservation System.
 *
 * Features:
 * ✔ Train Search
 * ✔ Ticket Booking
 * ✔ PNR Status
 * ✔ Ticket Cancellation
 * ✔ Aesthetic ANSI Console UI
 *
 * Run:
 * javac src/*.java -d out
 * java -cp out project_1.IRCTCMain
 */

public class IRCTCMain {

    // ─────────────────────────────────────────────────────────
    // ANSI COLORS
    // ─────────────────────────────────────────────────────────

    public static final String R      = "\u001B[0m";
    public static final String B      = "\u001B[1m";

    public static final String BLACK  = "\u001B[30m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String GOLD   = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String WHITE  = "\u001B[37m";
    public static final String GRAY   = "\u001B[90m";

    // ─────────────────────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────────────────────

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TrainDatabase db       = new TrainDatabase();
        SearchService search   = new SearchService(db, scanner);
        BookingService booking = new BookingService(db, scanner);

        clearScreen();
        printBanner();
        loadingAnimation();

        boolean exit = false;

        while (!exit) {

            printMainMenu();

            System.out.print(B + GOLD + "\n  ❯ Enter Your Choice: " + R);

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    search.start();
                    break;

                case "2":
                    booking.start();
                    break;

                case "3":
                    printSystemInfo();
                    break;

                case "0":
                    exit = true;
                    break;

                default:
                    System.out.println(
                            RED + "\n  [!] Invalid Choice. Please enter between 0 - 3." + R
                    );
            }
        }

        printExitScreen();

        scanner.close();
    }

    // ─────────────────────────────────────────────────────────
    // BEAUTIFUL LANDING BANNER
    // ─────────────────────────────────────────────────────────

    private static void printBanner() {

        System.out.println(CYAN + B);

        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                            ║");
        System.out.println("║    ██╗██████╗   ██████╗████████╗ ██████╗      ██████╗ ██████╗  ██████╗     ║");
        System.out.println("║    ██║██╔══██╗ ██╔════╝╚══██╔══╝██╔════╝      ██╔══██╗██╔══██╗██╔═══██╗    ║");
        System.out.println("║    ██║██████╔╝ ██║        ██║   ██║           ██████╔╝██████╔╝██║   ██║    ║");
        System.out.println("║    ██║██╔══██╗ ██║        ██║   ██║           ██╔═══╝ ██╔══██╗██║   ██║    ║");
        System.out.println("║    ██║██║  ██║ ╚██████╗   ██║   ╚██████╗      ██║     ██║  ██║╚██████╔╝    ║");
        System.out.println("║    ╚═╝╚═╝  ╚═╝  ╚═════╝   ╚═╝    ╚═════╝      ╚═╝     ╚═╝  ╚═╝ ╚═════╝     ║");
        System.out.println("║                                                                            ║");

        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");

        System.out.println(PURPLE + B +
                "║              🚄 NEXT-GEN RAILWAY RESERVATION SYSTEM 🚄                  ║");

        System.out.println(CYAN +
                "║                                                                            ║");

        System.out.println(GOLD +
                "║   ✦ Real-Time Train Search                                                 ║");

        System.out.println(GREEN +
                "║   ✦ Smart Ticket Booking & Cancellation                                    ║");

        System.out.println(CYAN +
                "║   ✦ Instant PNR Generation & Status Tracking                               ║");

        System.out.println(PURPLE +
                "║   ✦ Dynamic Seat Availability Management                                   ║");

        System.out.println(RED +
                "║   ✦ Premium ANSI Console Experience                                        ║");

        System.out.println(CYAN +
                "║                                                                            ║");

        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");

        System.out.println(B + GOLD +
                "║                 Developed Using Java • OOP • Collections                  ║");

        System.out.println(CYAN +
                "║                                                                            ║");

        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");

        System.out.println(R);
    }

    // ─────────────────────────────────────────────────────────
    // LOADING EFFECT
    // ─────────────────────────────────────────────────────────

    private static void loadingAnimation() {

        System.out.print(GREEN + B + "\n  Initializing Railway Services ");

        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(350);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(CYAN + "● ");
        }

        System.out.println(GREEN + "\n  ✔ System Ready Successfully!\n" + R);
    }

    // ─────────────────────────────────────────────────────────
    // MAIN MENU
    // ─────────────────────────────────────────────────────────

    private static void printMainMenu() {

        System.out.println(CYAN +
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");

        System.out.println(
                "┃                " + B + "C O N S O L E   D A S H B O A R D" + R + CYAN + "                ┃"
        );

        System.out.println(
                "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫"
        );

        System.out.println(
                "┃                                                                  ┃"
        );

        System.out.println(
                "┃   " + GOLD + "[1]" + R + CYAN + "  Search & Discover Trains                         ┃"
        );

        System.out.println(
                "┃   " + GOLD + "[2]" + R + CYAN + "  Ticket Booking & PNR Management                  ┃"
        );

        System.out.println(
                "┃   " + GOLD + "[3]" + R + CYAN + "  System Information                               ┃"
        );

        System.out.println(
                "┃   " + RED + "[0]" + R + CYAN + "  Exit Application                                 ┃"
        );

        System.out.println(
                "┃                                                                  ┃"
        );

        System.out.println(
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"
                        + R
        );
    }

    // ─────────────────────────────────────────────────────────
    // ABOUT / SYSTEM INFO
    // ─────────────────────────────────────────────────────────

    private static void printSystemInfo() {

        System.out.println("\n" + PURPLE + B);

        System.out.println("╔════════════════ SYSTEM INFORMATION ════════════════╗");

        System.out.println("║                                                    ║");

        System.out.println("║   🚄 Project : IRCTC Reservation System            ║");

        System.out.println("║   💻 Language: Java                                ║");

        System.out.println("║   🧠 Concepts: OOP, Collections, Services          ║");

        System.out.println("║   🎨 UI Style: ANSI Terminal Dashboard             ║");

        System.out.println("║   ⚡ Database : In-Memory Train Storage            ║");

        System.out.println("║                                                    ║");

        System.out.println("╚════════════════════════════════════════════════════╝");

        System.out.println(R);
    }

    // ─────────────────────────────────────────────────────────
    // EXIT SCREEN
    // ─────────────────────────────────────────────────────────

    private static void printExitScreen() {

        System.out.println(CYAN);

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        System.out.println(GOLD + B +
                "             Thank You For Using IRCTC-PRO");

        System.out.println(CYAN +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        System.out.println(GREEN + B +
                "\n  ✔ Closing System Safely... Happy Journey! 🚂\n" + R);
    }

    // ─────────────────────────────────────────────────────────
    // CLEAR TERMINAL SCREEN
    // ─────────────────────────────────────────────────────────

    private static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
            else {

                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        } catch (Exception e) {

            // Ignore if terminal clear fails
        }
    }
}