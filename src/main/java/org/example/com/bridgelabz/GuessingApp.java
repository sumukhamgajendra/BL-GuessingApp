package org.example.com.bridgelabz;

import java.util.Scanner;

/**
 * Use Case 5: Game Result Storage
 *
 * Persists game result after completion.
 *
 * @author Sumukha
 * @version 5.0
 */
public class GuessingApp {

    public static void main(String[] args)
            throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing App");
        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false;

        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            int guess;
            try {
                guess = ValidationService
                        .validateInput(scanner.nextLine());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            attempts++;

            String result = GuessValidator.validateGuess(
                    guess,
                    config.getTargetNumber()
            );

            if (!"CORRECT".equals(result)
                    && hintsUsed < config.getMaxHints()) {

                hintsUsed++;
                System.out.println(
                        HintService.generateHint(
                                config.getTargetNumber(),
                                hintsUsed
                        )
                );
            }

            System.out.println(result);

            if ("CORRECT".equals(result)) {
                win = true;
                break;
            }
        }

        StorageService.saveResult(player, attempts, win);
        scanner.close();
    }
}
