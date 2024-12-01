package phadungkit.naphat.lab2;

/*
 * This program simulates a Rock-Paper-Scissors game between two players.
 * The program takes two arguments representing the choices of Player 1 and Player 2.
 * It compares these choices and determines the winner based on standard rules.
 * The program handles invalid inputs by checking if the choices match the expected options.
 * 
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 2 December 2024
 */
public class RockPaperScissors {

    public enum Choice {
        ROCK, PAPER, SCISSORS;
    }

    public static void main(String[] args) {

        // Validate that the program receives exactly two arguments
        if (args.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
            return;
        }

        // Convert both player inputs to uppercase to handle case insensitivity
        String playerOneChoose = args[0].toUpperCase();
        String playerTwoChoose = args[1].toUpperCase();

        // Convert the input strings into the enum values
        try {
            Choice playerOneToEnum = Choice.valueOf(playerOneChoose); // Convert to enum
            Choice playerTwoToEnum = Choice.valueOf(playerTwoChoose); // Convert to enum
            System.out.println("Player 1 chooses: " + playerOneToEnum); // Display player's choice
            System.out.println("Player 2 chooses: " + playerTwoToEnum); // Display player's choice

            // Determine the winner using if-else conditions based on the rules of the game
            if (playerOneToEnum == Choice.ROCK && playerTwoToEnum == Choice.SCISSORS) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == Choice.SCISSORS && playerTwoToEnum == Choice.PAPER) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == Choice.PAPER && playerTwoToEnum == Choice.ROCK) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == playerTwoToEnum) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Player 2 wins!");
            }
        } // Handle any invalid inputs that don't match the enum choices
        catch (IllegalArgumentException error) {
            System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', and 'scissors'.");
        }
    }
}
