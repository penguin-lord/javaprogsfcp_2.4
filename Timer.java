
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int hour, min, sec;

        try (var input = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter Hour: ");
                hour = input.nextInt();

                System.out.println("Enter Minute: ");
                min = input.nextInt();

                System.out.println("Enter Second: ");
                sec = input.nextInt();

                if (hour < 0 || min < 0 || sec < 0 ||
                    min > 59 || sec > 59) {
                    System.out.println("Invalid input! Try again.");
                    continue;
                }

                break;
            }

            while (hour > 0 || min > 0 || sec > 0) {
                clearScreen();

                System.out.printf("%02d:%02d:%02d%n",
                                  hour, min, sec);

                Thread.sleep(1000);

                if (sec > 0) {
                    sec--;
                } else if (min > 0) {
                    sec = 59;
                    min--;
                } else if (hour > 0) {
                    min = 59;
                    sec = 59;
                    hour--;
                }
            }

            clearScreen();
            System.out.println("Countdown is Finished!");
        }
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
