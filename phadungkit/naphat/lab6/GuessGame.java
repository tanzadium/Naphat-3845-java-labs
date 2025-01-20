package phadungkit.naphat.lab6;

import java.util.Scanner;

/*
 * This is the base class for the number guessing game that implements core functionality.
 * The game generates a random number within a specified range, and players must guess it
 * within a maximum number of attempts. The class provides methods for configuring game
 * parameters, generating random numbers, and handling the game logic.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 January 2025
 */
public class GuessGame {

    private int minRange;    
    private int maxRange;   
    private int maxTry;     
    private int answer;      
    private int attempts;   

    //Default constructor that initializes the game with preset values:
    public GuessGame() {
        this.minRange = 1;
        this.maxRange = 100;
        this.maxTry = 10;
        this.attempts = 0;
        this.answer = 0;
    }

    //Parameterized constructor for custom game configuration

    public GuessGame(int min, int max, int maxTry) {
        this.minRange = min;
        this.maxRange = max;
        this.maxTry = maxTry;
        this.answer = 0;
        this.attempts = 0;
    }

    public int getMin() {
        return minRange;
    }

    public void setMin(int minRange) {
        this.minRange = minRange;
    }

    public int getMax() {
        return maxRange;
    }

    public void setMax(int maxRange) {
        this.maxRange = maxRange;
    }

    public int getMaxTries() {
        return maxTry;
    }

    public void setMaxTries(int maxTry) {
        this.maxTry = maxTry;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    //Configures the game with new parameters
    public void configureGame(int min, int max, int maxTry) {
        this.minRange = min;
        this.maxRange = max;
        this.maxTry = maxTry;
    }

    /*
     * Generates a random number between minRange and maxRange (inclusive)
     * Uses Math.random() to create the random number
     */
    public void generateAnswer() {
        answer = (int) (Math.random() * (maxRange - minRange + 1) + minRange);
    }

    /*
     * Implements the main game logic for a single game session
     * - Generates new random number
     * - Handles user input
     * - Validates guesses
     * - Provides feedback
     * - Tracks attempts
     */
    public boolean playSingleGame() {
        Scanner getData = new Scanner(System.in);
        int guess;
        generateAnswer();
        System.out.println("Welcome to a number guessing game!");
        
        do {
            System.out.print("Enter an integer between " + minRange + " and " + maxRange + ": ");
            guess = getData.nextInt();
            attempts++;
            
            // Validate guess is within range
            if (guess < minRange || guess > maxRange) {
                System.out.println("The number must be between " + minRange + " and " + maxRange);
                attempts--;  // Don't count invalid guesses
            } 
            // Check if guess is correct
            else if (guess == answer) {
                // Display appropriate message based on number of attempts
                if (attempts == 1) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempt.");
                    return true;
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attemps.");
                    return true;
                }
            } 
            // Provide hints for incorrect guesses
            else if (guess < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }
        } while (attempts < maxTry);  // Continue until max tries reached

        // Player has run out of tries
        System.out.println("Sorry, you've used all attempts. The correct answer was: " + answer);
        return false;
    }
}