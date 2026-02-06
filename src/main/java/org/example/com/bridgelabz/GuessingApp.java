package org.example.com.bridgelabz;
import java.util.Scanner;

/**
 * Use Case 4: Error Handling & Validation
 *
 * Ensures all inputs are validated safely.
 *
 * @version 4.0
 */
public class GuessingApp {

    public static void main(String[] args)
            throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;

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
                break;
            }
        }

        scanner.close();
    }
}
