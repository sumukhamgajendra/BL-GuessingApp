package org.example.com.bridgelabz;

import java.util.Scanner;

/**
 * Handles game restart or exit decision.
 */
class GameController {

    public static boolean restartGame(Scanner scanner) {

        System.out.print("\nDo you want to play again? (Y/N): ");
        String choice = scanner.nextLine().trim().toUpperCase();

        return choice.equals("Y");
    }
}
