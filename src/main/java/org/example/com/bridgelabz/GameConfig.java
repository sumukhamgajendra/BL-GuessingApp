package org.example.com.bridgelabz;

import java.util.Random;

class GameConfig {

    // Constants
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;

    // Game state
    private int targetNumber;

    /**
     * Constructor is automatically called when a GameConfig object is created.
     * It initializes the random target number for the game.
     */
    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void showRules() {
        System.out.println("🎯 Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}
