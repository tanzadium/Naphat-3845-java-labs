package phadungkit.naphat.lab4;

/*
 * The program allows players to practice guessing numbers within a given range 
 * and check their performance based on statistics such as the number of guesses used,
 * win rate, and the number of correct guesses in the lowest number of rounds.
 * It also has a function that allows players to check their guessing history 
 * and choose to replay the game as desired.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 16 December 2024
 */
import java.util.Scanner;

public class NumberGuessingMethodGamesV3 {
    // Declare variables for the game configuration and gameplay
    static Scanner getData = new Scanner(System.in);  // Scanner object for user input
    static int minRange, maxRange, maxTry, randomNumber, range, tried, specificGuess, numTimesGame = 0, sumGuess = 0, totalWin = 0, lowestTries = 100;
    static int[] userGuessHistory = new int[10];  // Array to store the user's guess history (up to 10 guesses)
    static String guessWantReview;  // Variable to store user's choice to review guesses
    static boolean userStatus;

    public static void main(String[] args) {
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
        while (maxRange < minRange) {
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = getData.nextInt();
        }

        // Set the maximum number of tries and validate it is greater than 0
        System.out.print("Enter the maximum of tries:");
        maxTry = getData.nextInt();
        while (maxTry <= 0) {
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
        userStatus = false;

        // Loop to let the user guess numbers until they succeed or run out of tries
        while (true) {
            if (tried < maxTry) {  // Check if there are attempts remaining
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + ":");
                int userGuess = getData.nextInt();  // Get user's guess
                tried += 1;
                sumGuess++;

                // Store the user's guess in the history array if less than 10 guesses made
                if (guessHistory < 10) {
                    userGuessHistory[guessHistory] = userGuess;
                    guessHistory++;
                }

                // Check if the user's guess is outside the allowed range
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried -= 1;
                    guessHistory--;
                    sumGuess--;
                } else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                } else if (userGuess == randomNumber) {
                    System.out.println("Congratulations!");
                    // Provide feedback on the number of tries used
                    System.out.println("You have tried " + tried + (tried == 1 ? " time." : " times."));
                    userStatus = true;
                    totalWin++;
                    updateHighScore();
                    return;  // Exit the method since the game is won
                }
            } else {  // If max tries are reached
                System.out.println("You have tried " + tried + (tried == 1 ? " time. " : " times. ") + "You ran out of guesses");
                System.out.println("The Answer is " + randomNumber);  // Show the correct answer
                break;
            }
        }
    }

    // Method to update high score based on the lowest number of guesses
    private static void updateHighScore() {
        if (userStatus && tried < lowestTries) {
            lowestTries = tried;
        }
    }

    // Method to start and repeat the game until the user decides to quit
    private static void playGames() {
        do {
            playGame(); 
            numTimesGame++; // Increment games here
            displayGuessesLoop();
        } while (playAgain());  // Ask if the user wants to play again
        System.out.println("Thank you for playing our games. Bye!");
        displayAllGameStats();
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
                if (specificGuess > 0 && specificGuess <= tried) {
                    System.out.println("Guess " + specificGuess + ": " + userGuessHistory[specificGuess - 1]);
                }
            } else {
                displayGameLog();
                break;  // Exit the review loop
            }
        } while (true);  // Loop until the user decides to quit reviewing guesses
    }

    // Method to display the game log for each game
    private static void displayGameLog() {
        System.out.println("Game log: Answer: " + randomNumber + ", Guesses: " + tried + ", Win: " + (userStatus ? "True" : "False"));
    }

    // Method to display all game statistics after the user decides to quit
    private static void displayAllGameStats() {
        System.out.println("===== All Games Stats =====");
        System.out.println("Total games played: " + numTimesGame);
        System.out.println("Total games win: " + totalWin);
        double winRatio = numTimesGame > 0 ? ((double) totalWin / numTimesGame) * 100 : 0;
        System.out.printf("Win ratio: %.1f%%\n", winRatio);
        double avgGame = numTimesGame > 0 ? ((double) sumGuess / numTimesGame) : 0; // Fixed division by zero issue
        System.out.println("Average number of guesses per game: " + avgGame);
        System.out.println("High score (the lowest number of guesses): " + (lowestTries == 100 ? "None" : lowestTries));
    }

    // Wrapper method to call displayGuesses method for reviewing the guesses
    private static void displayGuessesLoop() {
        displayGuesses();
    }
}