package phadungkit.naphat.lab6;

import java.util.Scanner;

/*
 * This class implements an enhanced version of the number guessing game
 * with improved input validation and game configuration display.
 * It manages the game loop and handles user interactions for Version 2
 * of the number guessing game.
 * 
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 January 2025
 */
public class NumberGuessingOOPGameV2 {

    public static Scanner getData = new Scanner(System.in);  
    private GuessGameV2 game; 
    public int minRange, maxRange, maxTry; 

    // Gets and validates game configuration from the player
    public void configure() {

        System.out.print("Enter the min value: ");
        minRange = getData.nextInt();
        System.out.print("Enter the max value: ");
        maxRange = getData.nextInt();
        
        // Validate max is greater than or equal to min
        while (maxRange < minRange) {
            System.out.println("Invalid input: max value must be greater than or equal to min value.");
            System.out.print("Enter the min value: ");
            minRange = getData.nextInt();
            System.out.print("Enter the max value: ");
            maxRange = getData.nextInt();
        }

        System.out.print("Enter the maximum number of tries: ");
        maxTry = getData.nextInt();

        // Ensure maximum tries is greater than 0
        while (maxTry <= 0) {
            System.out.println("The maximum number of tries must be greater than 0.");
            System.out.print("Enter the maximum number of tries: ");
            maxTry = getData.nextInt();
        }

        // Create new game instance with validated parameters
        this.game = new GuessGameV2(minRange, maxRange, maxTry);

        // Configure the game with validated settings
        this.game.configureGame(minRange, maxRange, maxTry);

        // Display current game configuration
        System.out.println(this.game.toString());
    }

    public void playGames() {
        boolean playAgain;
        do {
            // Play a single game and get result
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");

            // Ask if player wants another game
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = getData.next().equalsIgnoreCase("y");

            if (playAgain) {
                configure();  // Get new settings for next game
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Gusessing Game V2!");
        getData.close();
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();  // Initial game configuration
        program.playGames();  // Start game loop
    }
}