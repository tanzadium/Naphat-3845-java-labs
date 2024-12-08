package phadungkit.naphat.lab3;

/*
 * This program works by taking integer data from the user using a scanner 
 * and using the Math.random() function to calculate the obtained value as a number 
 * that the user must guess correctly within 5 attempts.
 * The range that the function uses to randomly generate a number is 1 - 10 
 * and the user is asked to guess a number in the range as well.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 8 December 2024
 */
import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        System.out.println("Welcome to a number guessing game!");
        Scanner userGuess = new Scanner(System.in); // Get data from user

        int tried = 0;

        int maxRange = 10;
        int minRange = 1;
        int range = (maxRange - minRange) + 1; // Define range

        int randomNumber = minRange + (int) (Math.random() * range); // Random number

        while (true) {
            if (tried != 5) {
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + " :");
                int readUserGuess = userGuess.nextInt();
                tried = tried + 1;

                // Compare user guessing with random number
                if (readUserGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                } else if (readUserGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                } else if (readUserGuess == randomNumber) {
                    System.out.println("Congratulations!");

                    // Show the number of tried.
                    if (tried > 1) {
                        System.out.println("You have tried " + tried + " times. ");
                    } else {
                        System.out.println("You have tried " + tried + " time. ");
                    }
                    break;
                }
            } else {
                System.out.println("You have tried " + tried + " times" + "You ran out of guesses");
                break;
            }

        }
        userGuess.close();
    }
}
