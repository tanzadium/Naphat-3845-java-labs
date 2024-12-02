package phadungkit.naphat.lab3;

import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        System.out.println("Welcome to a number guessing game!");
        Scanner userGuess = new Scanner(System.in);

        int tried = 0;

        int maxRange = 10;
        int minRange = 1;
        int range = (maxRange - minRange) + 1;

        int randomNumber = minRange + (int) (Math.random() * range);

        while (true) {
            if (tried != 5) {
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + " :");
                int readUserGuess = userGuess.nextInt();
                tried = tried + 1;

                if (readUserGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                } else if (readUserGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                } else if (readUserGuess == randomNumber) {
                    System.out.println("Congratulations!");
                    if (tried > 1) {
                        System.out.println("You have tried " + tried + " times");
                    } else {
                        System.out.println("You have tried " + tried + " time");
                    }
                    break;
                }
            } else {
                System.out.println("You have tried " + tried + " times");
                break;
            }

        }
    }
}
