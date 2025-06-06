package phadungkit.naphat.lab3;

import java.util.Scanner;

/*
 * This program is a configurable number guessing game where the user
 * can set a minimum and maximum range of numbers and the maximum number 
 * of tries. The game generates a random number within the given range, 
 * and the user has to guess that number within the allowed attempts.
 *
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 8 December 2024
 */
public class ConfigurableNumberGuessingGame {

    static int minRange, maxRange, maxTry, randomNumber;

    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in); //Collect data from users via keyboard
        minRange = minValue(getData);
        maxRange = maxValue(getData);
        maxTry = maxTry(getData);
        randomNumber = randomNumber();
        System.out.println("Welcome to a number guessing game!");
        gamePlay(getData);
    }

    private static int minValue(Scanner getData) {
        //This method takes the min range value from the user and returns it to a class variable.
        System.out.print("Enter the min value:");
        minRange = getData.nextInt();
        return minRange;
    }

    private static int maxValue(Scanner getData) {
        //This method takes the max range value from the user and returns it to a class variable.
        System.out.print("Enter the max value:");
        maxRange = getData.nextInt();
        //Create a loop to check if the maximum value is greater than the minimum value.
        while (true) {
            if (maxRange >= minRange) {
                break;
            } else if (maxRange < minRange) {
                System.out.println("The max value must be at least equal to the min value");
                System.out.print("Enter the max value:");
                maxRange = getData.nextInt();
            }
        }
        return maxRange;
    }

    private static int maxTry(Scanner getData) {
        System.out.print("Enter the maximum of tries:");
        maxTry = getData.nextInt();
        //Create a loop to check if the maxTry value is greater than 0.
        while (true) {
            if (maxTry > 0) {
                break;
            } else if (maxTry <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
                System.out.print("Enter the maximum of tries:");
                maxTry = getData.nextInt();
            }
        }
        return maxTry;
    }

    private static int randomNumber() {
        /*This method generates the first random number using a range 
         *from the min and max values ​​entered by the user.
         *and returns the value to a class variable.
         */
        int range = (maxRange - minRange) + 1;
        randomNumber = minRange + (int) (Math.random() * (range));
        return randomNumber;
    }

    private static void gamePlay(Scanner getData) {
        /*This method checks if the user input value is within the specified range 
         *and also checks if the input value is greater than,
         *less than or equal to the value that the program randomly generates.
         *After that, it will display the number of times the user guessed, 
         *excluding the times the user guessed beyond the specified range. 
         *If the user guessed until the number of times but still not correct, 
         *the system will display the correct answer.
         */
        int tried = 0;
        while (true) {
            if (tried < maxTry) {
                System.out.print("Enter an integer between " + minRange + " and " + maxRange + ":");
                int userGuess = getData.nextInt();
                tried += 1;
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("The number must be between " + minRange + " and " + maxRange);
                    tried -= 1;
                } else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Try a lower number!");
                } else if (userGuess == randomNumber) {
                    System.out.println("Congratulations!");
                    if (tried == 1) {
                        System.out.println("You have tried " + tried + " time.");
                    } else if (tried > 1 && tried < maxTry) {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    return;
                }
            } else if (tried == maxTry) {
                System.out.println("You have tried " + tried + " times. " + "You ran out of guesses");
                System.out.println("The Answer is " + randomNumber);
                break;
            }
        }
    }
}
