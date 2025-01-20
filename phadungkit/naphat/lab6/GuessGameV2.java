package phadungkit.naphat.lab6;

import java.util.Scanner;

/*
 * This class extends GuessGame to provide an enhanced version of the number guessing game.
 * It adds improved configuration options, better game state tracking, and enhanced feedback.
 * Version 2 introduces a toString() method for game state representation and improved
 * game play mechanics.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 January 2025
 */
public class GuessGameV2 extends GuessGame {

    Scanner getData = new Scanner(System.in);

    public GuessGameV2() {
        super();  // Call parent class constructor
    }

    //Parameterized constructor that allows custom game configuration

    public GuessGameV2(int min, int max, int maxTry) {
        super(min, max, maxTry);  // Initialize base class with parameters
    }

    /*
     * Configures the game with new parameters
     * Overrides the parent class method to ensure proper setup in V2
     */
    @Override
    public void configureGame(int min, int max, int maxTry) {
        // Set individual game parameters
        setMin(min);
        setMax(max);
        setMaxTries(maxTry);

        // Call parent class configuration
        super.configureGame(min, max, maxTry);
    }

    /*
     * Creates a string representation of the current game state
     * Useful for debugging and displaying game configuration
     */
    public String toString() {
        return "Game Configuration: [Min: " + getMin() + 
               ", Max: " + getMax() + 
               ", Max Tries: " + getMaxTries() + 
               ", Attempts: " + getAttempts() + "]";
    }

    /*
     * Implements the main game logic for a single game session
     * Overrides the parent class method to provide enhanced feedback and validation
     */
    @Override
    public boolean playSingleGame() {
        this.generateAnswer();
        int guess;
        int attempts = 0;
        System.out.println("Welcome to a number guessing game V2!");

        do {
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            guess = getData.nextInt();
            attempts++;

            // Validate guess is within allowed range
            if (guess < getMin() || guess > getMax()) {
                System.out.println("The number must be between " + getMin() + " and " + getMax());
                attempts--; // Don't count invalid guesses against the player
            } 
            // Handle correct guess
            else if (guess == getAnswer()) {
                // Display win message with proper grammar based on attempts
                if (attempts == 1) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempt.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attemps.");
                }
                return true;
            } 
            // Provide hints for incorrect guesses
            else if (guess < getAnswer()) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        } while (attempts < getMaxTries());  // Continue until max tries reached

        // Player has run out of attempts
        System.out.println("Sorry, you've used all attempts. The correct answer was: " + getAnswer());
        return false;
    }
}