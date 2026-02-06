package org.example.com.bridgelabz;
/**
 * Use Case 2: User Guess Submission
 *
 * This class is responsible for comparing
 * the user's guess with the target number.
 *
 * It does NOT handle input or output.
 */
public class GuessValidator
{
    public static String validateGuess(int guess, int target) {

        if (guess == target) {
            return "CORRECT";
        } else if (guess < target) {
            return "LOW";
        }
        return "HIGH";
    }
}
