package phadungkit.naphat.lab3;

import java.util.Scanner;

/*
 * This program is a configurable number guessing game 
 * where the user can define a minimum and maximum number range and a maximum number of tries. 
 * The game generates a random number within the specified range and the user must guess 
 * that number within the specified number of tries and when finished, 
 * it asks the user again if they want to continue playing.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 9 December 2024
 */
public class NumberGuessingGames {

    // Declare variables so that all methods can access them.
    static int minRange, maxRange, maxTry, randomNumber;

    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in); //Collect data from users via keyboard

        //It receives input data and passes it to methods to continue working 
        //using do{} while(); to check the user's request to continue playing or not.
        minRange = minValue(getData);
        maxRange = maxValue(getData);
        maxTry = getMaxTry(getData);
        do {
            randomNumber = getRandomNumber();
            System.out.println("Welcome to a number guessing game!");
            gamePlay(getData);
            //If the condition is true, do{} is executed again; otherwise, the program is terminated.
        } while (playAgain(getData));
        System.out.println("Thank you for playing our games. Bye!");
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
            }
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = getData.nextInt();
        }
        return maxRange; //Returns a value to a class-level variable
    }

    private static int getMaxTry(Scanner getData) {
        //This method takes the max try value from the user and returns it to a class variable.
        System.out.print("Enter the maximum of tries:");
        int maxTry = getData.nextInt();
        //Create a loop to check if the maxTry value is greater than 0.
        while (true) {
            if (maxTry > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum of tries:");
            maxTry = getData.nextInt();
        }
        return maxTry; //Returns a value to a class-level variable
    }

    private static int getRandomNumber() {
        /*This method generates the first random number using a range 
         *from the min and max values ​​entered by the user
         *and returns the value to a class variable.
         */
        int range = (maxRange - minRange) + 1;
        int randomNumber = minRange + (int) (Math.random() * range);
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
                // Check if the player's guessed value is outside the specified range.
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
                    } else {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    return;
                }
            } else if (tried == maxTry) {
                if(maxTry == 1){
                System.out.println("You have tried " + tried + " time. " + "You ran out of guesses");
                System.out.println("The Answer is " + randomNumber);
                break;
            } else {
                System.out.println("You have tried " + tried + " times. " + "You ran out of guesses");
                System.out.println("The Answer is " + randomNumber);
                break;
            }
            
            }
        }
    }

    private static boolean playAgain(Scanner getData) {
        /*This method asks the player if they want to play again, 
         *takes the value and compares it to Y , regardless of case, 
         *and returns a class variable as true or false ,
         *since boolean holds true and false .
         */
        System.out.print("Want to play again (Y or y):");
        String userWant = getData.next();
        return userWant.equalsIgnoreCase("Y");
    }
}
