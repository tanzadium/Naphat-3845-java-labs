package phadungkit.naphat.lab4;

import java.util.Scanner;

/*
 * The purpose of the program is that the user can set the range of numbers 
 * that they want to be randomly generated and the number of guesses. 
 * The program will generate a number within the specified range and have the user guess 
 * that number within the specified number of guesses. 
 * The program will tell the user whether the guessed number is higher or lower than the random number. 
 * After the game is over, the user can view the history of all guesses or guess only one number at a time.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 16 December 2024
 */

public class NumberGuessingMethodGamesV2 {

    // Declare variables for the game configuration and gameplay
    static Scanner getData = new Scanner(System.in);  // Scanner object for user input
    static int minRange, maxRange, maxTry, randomNumber, range, tried, specificGuess;  // Game variables
    static int[] userGuessHistory = new int[10];  // Array to store the user's guess history (up to 10 guesses)
    static String guessWantReview;  // Variable to store user's choice to review guesses

    public static void main(String[] args) {
        // Start by configuring the game and then start playing
        configure();  
        playGames();
    }

    // Method to configure the game: set minimum/maximum range and number of tries
    private static void configure() {
        System.out.print("Enter the min value:");
        minRange = getData.nextInt();  // User sets minimum range
        System.out.print("Enter the max value:");
        maxRange = getData.nextInt();  // User sets maximum range
        
        // Ensure that the maximum range is not less than the minimum range
        while (true) {
            if (maxRange >= minRange) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = getData.nextInt();
        }
        
        // Set the maximum number of tries and validate it is greater than 0
        System.out.print("Enter the maximum of tries:");
        maxTry = getData.nextInt();
        while (true) {
            if (maxTry > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum of tries:");
            maxTry = getData.nextInt();
        }
    }

    // Method to generate a random number between minRange and maxRange
    private static void genAnswer() {
        range = (maxRange - minRange) + 1;  // Calculate the range size
        randomNumber = minRange + (int) (Math.random() * range);  // Generate random number
    }

    // Core method to play the game
    private static void playGame() {
        genAnswer();  // Generate the random number to be guessed
        System.out.println("Welcome to a number guessing game!");
        tried = 0;  // Initialize the number of tries used
        int guessHistory = 0;  // Track the user's guess history index
        
        // Loop to let the user guess numbers until they succeed or run out of tries
        while (true) {
            if (tried < maxTry) {  // Check if there are attempts remaining
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + ":");
                int userGuess = getData.nextInt();  // Get user's guess
                tried += 1;  // Increment tries
                
                // Store the user's guess in the history array if less than 10 guesses made
                if (guessHistory < 10) {
                    userGuessHistory[guessHistory] = userGuess;
                    guessHistory++;
                }

                // Check if the user's guess is outside the allowed range
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried -= 1;  // Invalid guess, decrement the tries
                    guessHistory--;  // Decrement guess history index
                } else if (userGuess < randomNumber) {  // If guess is lower than the answer
                    System.out.println("Try a higher number!");
                } else if (userGuess > randomNumber) {  // If guess is higher than the answer
                    System.out.println("Try a lower number!");
                } else if (userGuess == randomNumber) {  // If guess matches the answer
                    System.out.println("Congratulations!");
                    // Provide feedback on the number of tries used
                    if (tried == 1) {
                        System.out.println("You have tried " + tried + " time.");
                    } else {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    return;  // Exit the method since the game is won
                }
            } else if (tried == maxTry) {  // If max tries are reached
                if (maxTry == 1) {
                    System.out.println("You have tried " + tried + " time. " + "You ran out of guesses");
                    System.out.println("The Answer is " + randomNumber);  // Show the correct answer
                    break;
                } else {
                    System.out.println("You have tried " + tried + " times. " + "You ran out of guesses");
                    System.out.println("The Answer is " + randomNumber);  // Show the correct answer
                    break;
                }
            }
        }
    }

    // Method to start and repeat the game until the user decides to quit
    private static void playGames() {
        do {
            playGame();  // Play one game
            displayGuessesLoop();  // After the game, allow the user to review their guesses
        } while (playAgain());  // Ask if the user wants to play again
        System.out.println("Thank you for playing our games. Bye!");
    }

    // Method to ask the user if they want to play another round
    private static boolean playAgain() {
        System.out.print("Want to play again (Y or y):");
        String userWant = getData.next();  // Get user's input
        return userWant.equalsIgnoreCase("Y");  // Check if the user wants to play again
    }

    // Method to display guesses after each game based on user choice
    private static void displayGuesses() {
        do {
            // Ask the user if they want to see all guesses or a specific guess
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            guessWantReview = getData.next();
            
            if (guessWantReview.equalsIgnoreCase("a")) {
                // Display all guesses made during the game
                for (int i = 0; i < tried; i++) {
                    System.out.println("Guess " + (i + 1) + ": " + userGuessHistory[i]);
                }
            } else if (guessWantReview.equalsIgnoreCase("g")) {
                // Display a specific guess based on user input
                System.out.print("Enter the guess number: ");
                specificGuess = getData.nextInt();
                if (specificGuess > 0 && specificGuess < userGuessHistory.length) {
                    System.out.println("Guess " + specificGuess + ": " + userGuessHistory[specificGuess - 1]);
                }
            } else {
                userGuessHistory = new int[10];  // Reset guess history and exit
                break;
            }
        } while (true);  // Loop until the user decides to quit reviewing guesses
    }

    // Wrapper method to call displayGuesses method for reviewing the guesses
    private static void displayGuessesLoop() {
        displayGuesses();
    }
}
