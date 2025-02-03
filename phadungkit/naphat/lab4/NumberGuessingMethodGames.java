package phadungkit.naphat.lab4;

/*
 * This is a number-guessing game where the user must guess a randomly generated number 
 * between a specified range. The user can define the minimum and maximum values 
 * for the range and the maximum number of attempts. 
 * After each game, the user is asked if they would like to play again.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 17 December 2024 (added comment)
 */
import java.util.Scanner;

public class NumberGuessingMethodGames {

    // Static variables to store game configurations and state
    static int minRange, maxRange, maxTry, randomNumber, range, tried;
    static Scanner getData = new Scanner(System.in);

    // Main method: Entry point of the program
    public static void main(String[] args) {
        // Set up the game configurations (min/max range and maximum tries)
        configure(getData);
        // Start playing the guessing games
        playGames(getData);
    }

    // Method: configure
    // Purpose: To get the user-defined configurations for the game such as the minimum value, 
    // maximum value, and the maximum number of tries.
    static void configure(Scanner getData) {
        // Prompt the user for the minimum value of the guessing range
        System.out.print("Enter the min value:");
        minRange = getData.nextInt();
        
        // Prompt the user for the maximum value of the guessing range
        System.out.print("Enter the max value:");
        maxRange = getData.nextInt();

        // Ensure that the maxRange is at least equal to minRange
        while (true) {
            if (maxRange >= minRange) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = getData.nextInt();
        }

        // Prompt the user for the maximum number of tries
        System.out.print("Enter the maximum of tries:");
        maxTry = getData.nextInt();

        // Ensure that the maximum number of tries is greater than 0
        while (true) {
            if (maxTry > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum of tries:");
            maxTry = getData.nextInt();
        }
    }

    // Method: genAnswer
    // Purpose: Generates a random number between the user-defined range (minRange and maxRange).
    static void genAnswer(Scanner getData) {
        // Calculate the range between minRange and maxRange, then generate a random number within that range
        range = (maxRange - minRange) + 1;
        randomNumber = minRange + (int) (Math.random() * range);
    }

    // Method: playGame
    // Purpose: Handles the core gameplay, where the user attempts to guess the random number.
    static void playGame(Scanner getData) {
        // Generate a new random number for the game
        genAnswer(getData);
        System.out.println("Welcome to a number guessing game!");
        tried = 0;  // Reset the number of tries

        // Start the guessing loop
        while (true) {
            if (tried < maxTry) {
                // Prompt the user to enter a guess within the valid range
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + ":");
                int userGuess = getData.nextInt();
                tried += 1;  // Increment the number of attempts

                // Check if the user's guess is outside the valid range
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried -= 1;  // Don't count this as a valid attempt
                }
                // Provide feedback if the guess is too low
                else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                }
                // Provide feedback if the guess is too high
                else if (userGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                }
                // Correct guess
                else if (userGuess == randomNumber) {
                    System.out.println("Congratulations!");
                    // Print how many tries it took
                    if (tried == 1) {
                        System.out.println("You have tried " + tried + " time.");
                    } else {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    return;  // End the game after a correct guess
                }
            }
            // If the user runs out of tries
            else if (tried == maxTry) {
                if (maxTry == 1) {
                    System.out.println("You have tried " + tried + " time. " + "You ran out of guesses");
                } else {
                    System.out.println("You have tried " + tried + " times. " + "You ran out of guesses");
                }
                // Reveal the correct answer
                System.out.println("The Answer is " + randomNumber);
                break;
            }
        }
    }
    //This method allows the user to keep playing new games until they choose to stop.
    static void playGames(Scanner getData) {
        do {
            playGame(getData);
        } while (playAgain(getData));  // Ask the user if they want to play again
        System.out.println("Thank you for playing our games. Bye!");  
    }

    //Asks the user if they want to play another game. Returns true if they do.
    static boolean playAgain(Scanner getData) {
        System.out.print("Want to play again (Y or y):");
        String userWant = getData.next();
        // Return true if the user enters 'Y' or 'y', false otherwise
        return userWant.equalsIgnoreCase("Y");
    }
}
