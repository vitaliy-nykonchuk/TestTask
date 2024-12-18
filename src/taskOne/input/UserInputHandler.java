package taskOne.input;

import java.util.Scanner;

public class UserInputHandler {

    // Method for reading an integer N from the keyboard
    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        int N;

        while (true) {
            System.out.print("Enter the number of bracket pairs (N): ");
            N = scanner.nextInt();
            if (N >= 0) {
                break;// Exit loop if N is non-negative
            }
            System.out.println("N must be a non-negative number. Please try again.");
        }

        return N;
    }
}