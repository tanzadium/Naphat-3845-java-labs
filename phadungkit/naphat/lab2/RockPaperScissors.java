package phadungkit.naphat.lab2;

/*
* To simulate the game of rock paper scissors by taking arguments from players and seeing who wins.
* Author : Naphat Phadungkit
* Student ID : 673040384-5
* Sec : 1
* Last updated date: 1 December 2024
 */
public class RockPaperScissors {

    public enum Choice {
        ROCK, PAPER, SCISSORS;
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Invalid number of arguments. Please provide exactly two arguments");
            return;
            // Check if the user has entered all the information.
        }

        String playerOneChoose = args[0].toUpperCase(); // Convert to Upper case
        String playerTwoChoose = args[1].toUpperCase(); // Convert to upper case

        // Use try catch to check if the received arguments match the values ​​in the enum.
        try {
            Choice playerOneToEnum = Choice.valueOf(playerOneChoose); // Change String to enum
            Choice playerTwoToEnum = Choice.valueOf(playerTwoChoose); // Change String to enum
            System.out.println("Player 1 chooses: " + playerOneToEnum); // Show what player choose
            System.out.println("Player 2 chooses: " + playerTwoToEnum); // Show what player choose

            if (playerOneToEnum == Choice.ROCK && playerTwoToEnum == Choice.SCISSORS) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == Choice.SCISSORS && playerTwoToEnum == Choice.PAPER) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == Choice.PAPER && playerTwoToEnum == Choice.ROCK) {
                System.out.println("Player 1 wins!");
            } else if (playerOneToEnum == playerTwoToEnum) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Player 2 win!");
            }
            // Use if else to check who win.
        } catch (IllegalArgumentException error) {
            System.err.println("Invalid choice(s). Valid choices are 'rock' , 'paper' and 'scissors'.");
            // If the argument does not match the value in the enum, an error is returned.
        }

    }

}