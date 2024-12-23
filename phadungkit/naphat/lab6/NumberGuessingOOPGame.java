package phadungkit.naphat.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {
    public static Scanner getData = new Scanner(System.in);
    private GuessGame game;

    public void configure(){
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
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = getData.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Gusessing Game!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGames();
    }
}
