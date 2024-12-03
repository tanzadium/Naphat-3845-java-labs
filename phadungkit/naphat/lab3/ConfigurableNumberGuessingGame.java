package phadungkit.naphat.lab3;

import java.util.Scanner;

/*
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 3 December 2024
 */
public class ConfigurableNumberGuessingGame {

    public static void main(String[] args) {
        
        //Import data from players
        Scanner userGuess = new Scanner(System.in);
        Scanner userMaxRange = new Scanner(System.in);
        Scanner userMinRange = new Scanner(System.in);
        Scanner userMaxTry = new Scanner(System.in);

        int tried = 0;

        System.out.print("Enter the min value:");
        int minRange = userMinRange.nextInt();

        //Create a loop to check if the maximum value is greater than the minimum value.
        System.out.print("Enter the max value:");
        int maxRange = userMaxRange.nextInt();
        while (true) {
            if (maxRange >= minRange) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = userMaxRange.nextInt();
            //If the player still bets the maximum value lower than the minimum value,
            //the player bets until the maximum value is higher than the minimum value.
        }

        //Create a loop to check if the number of times the player enters is greater than 0.
        System.out.print("Enter the maximum of tries:");
        int maxTry = userMaxTry.nextInt();
        while (true) {
            if (maxTry > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum of tries:");
            maxTry = userMaxTry.nextInt();
            //If the player enters a number of times less than 0, the player enters again until it is greater than 0.
        }

        int range = (maxRange - minRange) + 1;
        int randomNumber = minRange + (int) (Math.random() * range); 
        //Generate random numbers to compare with the user input numbers.

        System.out.println("Welcome to a number guessing game!");
        while (true) {
            if (tried != maxTry) {
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + ":");
                int readUserGuess = userGuess.nextInt();
                tried = tried + 1;
                if (readUserGuess < minRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried = tried - 1;
                } else if (readUserGuess > maxRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried = tried - 1;
                } else if (readUserGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                } else if (readUserGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                } else if (readUserGuess == randomNumber) {
                    System.out.println("Congratulations!");
                    if (tried > 1) {
                        System.out.println("You have tried " + tried + " times.");
                    } else {
                        System.out.println("You have tried " + tried + " time.");
                    }
                    break;
                }
            } else if (tried > 1) {
                System.out.println("You have tried " + tried + " times. " + "You ran out of guesses");
                System.out.println("The Answer is " + randomNumber);
                break;
            }
        }
    }
}
