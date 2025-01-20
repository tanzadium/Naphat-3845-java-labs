package phadungkit.naphat.lab6;

import java.util.Scanner;

/*
 * This class implements the most advanced version of the number guessing game.
 * It adds game record keeping, viewing capabilities, and a menu-driven interface.
 * The class manages game configuration, gameplay, and record viewing through
 * an enhanced user interface.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 20 JAnuary 2025
 */
public class NumberGuessingOOPGameV3 {
    public static Scanner getData = new Scanner(System.in);  
    private GuessGameV3 game;  

    /*
     * Configures the game with user input
     * Includes enhanced validation for min/max range and maximum tries
     */
    public void configure() {
        int minRange, maxRange, maxTry;

        // Get and validate min/max range with error checking
        do {
            System.out.print("Enter the min value: ");
            minRange = getData.nextInt();
            System.out.print("Enter the max value: ");
            maxRange = getData.nextInt();

            if (maxRange < minRange) {
                System.out.println("Invalid input: max must be greater than or equal to min.");
            }
        } while (maxRange < minRange);

        // Get and validate maximum tries
        do {
            System.out.print("Enter the maximum number of tries: ");
            maxTry = getData.nextInt();

            if (maxTry <= 0) {
                System.out.println("Invalid input: maxTries must be greater than 0.");
            }
        } while (maxTry <= 0);

        // Create new game instance with validated parameters
        this.game = new GuessGameV3(minRange, maxRange, maxTry);
    }

    /*
     * Displays and handles game record viewing
     * Includes input validation for record selection
     */
    public void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");
        
        int choice = getData.nextInt();
        
        if (choice == 1) {
            // Display all recorded games
            GuessGameV3[] records = GuessGameV3.getGameRecords();
            int count = GuessGameV3.getRecordCount();
            
            for (int i = 0; i < count; i++) {
                System.out.println("Game " + (i + 1) + ": " + records[i].getGameLog());
            }
        } else if (choice == 2) {
            // Get and validate specific game number
            System.out.print("Enter the game number to view: ");
            int gameNum = getData.nextInt();
            
            // Display specific game record if valid
            if (gameNum > 0 && gameNum <= GuessGameV3.getRecordCount()) {
                GuessGameV3[] records = GuessGameV3.getGameRecords();
                System.out.println("Game " + gameNum + ": " + records[gameNum - 1].getGameLog());
            } else {
                System.out.println("Invalid game number.");
            }
        }
    }

    /*
     * Manages the main game loop with enhanced menu system
     * Handles user choice and game flow
     */
    public void playGames() {
        boolean nextGame = true;
    
        while (nextGame) {
            // Play game
            if (game != null) {
                game.playSingleGame();
    
                boolean validChoice = false;
                while (!validChoice) {
                    // Show menu
                    System.out.println("Do you want to:");
                    System.out.println("1. Play again");
                    System.out.println("2. View game records");
                    System.out.println("3. Quit");
                    
                    int choice = getData.nextInt();
                    
                    switch (choice) {
                        case 1:
                            configure();  // Get new settings for next game
                            validChoice = true;  // Exit menu loop
                            break;
                        case 2:
                            viewRecords();  // Show game history
                            // Don't set validChoice, so menu shows again
                            break;
                        case 3:
                            nextGame = false;  // End program
                            validChoice = true;  // Exit menu loop
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    
        System.out.println("Thank you for playing Number Guessing Game V3!");
        getData.close();
    }

    /*
     * Main method - entry point of the program
     * Sets up initial game configuration and starts the game loop
     */
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();  // Initial game setup
        program.playGames();  // Start game loop with menu system
    }
}