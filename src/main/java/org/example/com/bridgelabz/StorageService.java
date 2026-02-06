package org.example.com.bridgelabz;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Use Case 5: Game Result Storage
 *
 * Stores game results in a file.
 */
class StorageService {

    public static void saveResult(String player,
                                  int attempts,
                                  boolean win) {

        try (BufferedWriter writer = new BufferedWriter( new FileWriter("game_results.txt", true))) {
            writer.write("Player: " + player
                    + ", Attempts: " + attempts
                    + ", Result: " + (win ? "WIN" : "LOSE"));
            writer.newLine();

        } catch (Exception e) {
            System.out.println("Unable to save game result.");
        }
    }
}
