package phadungkit.naphat.lab6;

import java.util.Scanner;

/*
 * This is the main program class for the basic OOP version of the number guessing game.
 * It provides a simple interface for configuring and playing the game, allowing users
 * to play multiple rounds and choose when to quit.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 January 2025
 */
public class NumberGuessingOOPGame {
    public static Scanner getData = new Scanner(System.in);
    
    // Instance of the game class that handles core game logic
    private GuessGame game;

    // Configures the initial game settings by getting user input
    public void configure() {
        System.out.print("Enter the min value: ");
        int minRange = getData.nextInt();
        
        System.out.print("Enter the max value: ");
        int maxRange = getData.nextInt(); 
        
        System.out.print("Enter the maximum number of tries: ");
        int maxTry = getData.nextInt();

        this.game = new GuessGame(minRange, maxRange, maxTry);
    }

    public void playGames() {
        boolean playAgain;
        do { 
            // Play one complete game and get result
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            
            // Ask if player wants another game
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = getData.next().equalsIgnoreCase("y");
            
            // If playing again, get new configuration
            if (playAgain) {
                configure();
            }
        } while (playAgain);  // Continue while player wants to play

        // Clean up and exit
        System.out.println("Thank you for playing the Number Gusessing Game!");
        getData.close();
    }

    /*
     * Main method - entry point of the program
     * Creates game instance, configures it, and starts play loop
     */
    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();  // Get initial configuration
        program.playGames();  // Start game loop
    }
}