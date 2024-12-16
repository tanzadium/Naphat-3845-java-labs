package phadungkit.naphat.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGames {

    static int minRange, maxRange, maxTry, randomNumber, range, tried;
    static Scanner getData = new Scanner(System.in);

    public static void main(String[] args) {
        configure(getData);
        playGames(getData);
    }

    static void configure(Scanner getData) {
        System.out.print("Enter the min value:");
        minRange = getData.nextInt();
        System.out.print("Enter the max value:");
        maxRange = getData.nextInt();
        while (true) {
            if (maxRange >= minRange) {
                break;
            }
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            maxRange = getData.nextInt();
        }
        System.out.print("Enter the maximum of tries:");
        maxTry = getData.nextInt();
        while (true) {
            if (maxTry > 0) {
                break;
            }
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum of tries:");
            maxTry = getData.nextInt();
        }
    }

    static void genAnswer(Scanner getData) {
        range = (maxRange - minRange) + 1;
        randomNumber = minRange + (int) (Math.random() * range);
    }

    static void playGame(Scanner getData) {
        genAnswer(getData);
        System.out.println("Welcome to a number guessing game!");
        tried = 0;
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
                    } else {
                        System.out.println("You have tried " + tried + " times.");
                    }
                    return;
                }
            } else if (tried == maxTry) {
                if (maxTry == 1) {
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

    static void playGames(Scanner getData) {
        do {
            playGame(getData);
        } while (playAgain(getData));
        System.out.println("Thank you for playing our games. Bye!");
    }

    static boolean playAgain(Scanner getData) {
        System.out.print("Want to play again (Y or y):");
        String userWant = getData.next();
        return userWant.equalsIgnoreCase("Y");
    }
}
