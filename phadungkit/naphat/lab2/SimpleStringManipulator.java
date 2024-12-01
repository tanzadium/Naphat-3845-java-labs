package phadungkit.naphat.lab2;

/* 
 * This program takes two string arguments from the command line. It performs the following string manipulations:
 * - If the first string starts with a vowel, the first character is converted to uppercase; otherwise, it is converted to lowercase.
 * - If the second string ends with a consonant, the last character is converted to uppercase; otherwise, it is converted to lowercase.
 * 
 * After performing these manipulations, the program concatenates the modified first and second strings, 
 * then outputs the original strings along with the resulting manipulated string.
 *
 * The program also includes error handling to ensure that exactly two string arguments are provided.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 2 December 2024
 */
public class SimpleStringManipulator {

    public static void main(String[] args) {

        // Validate that the program receives exactly two arguments
        if (args.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments.");
            return;
        }

        String firstWord = args[0];
        char firstChar = firstWord.charAt(0); // Convert string to char
        if (firstChar == 'a' || firstChar == 'A' || firstChar == 'e' || firstChar == 'E' || firstChar == 'i' || firstChar == 'I'
                || firstChar == 'o' || firstChar == 'O' || firstChar == 'u' || firstChar == 'U') {
            firstChar = Character.toUpperCase(firstChar); // If firstChar is not a vowel, change it to uppercase
        } else {
            firstChar = Character.toLowerCase(firstChar); // If firstChar is a vowel, change it to lowercase
        }

        String secondWord = args[1];
        char lastCharInSecondWord = secondWord.charAt(secondWord.length() - 1); // Convert last string to a char
        if (lastCharInSecondWord != 'a' && lastCharInSecondWord != 'A' && lastCharInSecondWord != 'e' && lastCharInSecondWord != 'E'
                && lastCharInSecondWord != 'i' && lastCharInSecondWord != 'I' && lastCharInSecondWord != 'o' && lastCharInSecondWord != 'O'
                && lastCharInSecondWord != 'u' && lastCharInSecondWord != 'U') {
            lastCharInSecondWord = Character.toUpperCase(lastCharInSecondWord); // If lastCharInSecondWord is not a vowel, change it to uppercase
        } else {
            lastCharInSecondWord = Character.toLowerCase(lastCharInSecondWord); // If lastCharInSecondWord is a vowel, change it to lowercase
        }
        // Create an object containing the results
        String result = firstChar + firstWord.substring(1) + secondWord.substring(0, secondWord.length() - 1) + lastCharInSecondWord;
        System.out.println("First String: " + firstWord);
        System.out.println("Second String: " + secondWord);
        System.out.println("Resulting String: " + result);
    }
}
