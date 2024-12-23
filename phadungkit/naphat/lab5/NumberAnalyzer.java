package phadungkit.naphat.lab5;

import java.util.Arrays;

/**
 * A utility class for performing common operations on arrays of numbers.
 * The class includes methods to find the minimum and maximum values, 
 * calculate running averages, check if an array is sorted, 
 * and print arrays in different formats.
 *
 * @author Naphat Phadungkit
 * @version 1.0
 */
public class NumberAnalyzer {

    /**
     * Finds the minimum and maximum values in an array of integers.
     * Sorts the array, then selects the first and last elements as min and max.
     *
     * @param numbers an array of integers
     * @return an array containing the minimum and maximum values
     */
    public static int[] findMinMax(int[] numbers) {
        int[] arrayFindMinMax = numbers.clone(); // Clone array to avoid modifying original
        Arrays.sort(arrayFindMinMax); // Sort the cloned array
        int min = arrayFindMinMax[0]; // First element is minimum
        int max = arrayFindMinMax[arrayFindMinMax.length - 1]; // Last element is maximum

        return new int[]{min, max}; // Return both min and max as a result array
    }

    /**
     * Calculates the running averages of an array of numbers.
     * Running average at position i is the average of all numbers up to i.
     *
     * @param numbers an array of integers
     * @return an array of running averages
     */
    public static double[] calculateRunningAverages(int[] numbers) {
        double currentSum = 0; // To keep a running sum of elements
        double[] averages = new double[numbers.length]; // Array to store running averages
        int[] findAvg = numbers.clone(); // Clone the input array
        double[] doublesTestingArray = Arrays.stream(findAvg).asDoubleStream().toArray(); // Convert to double

        // Loop through the array, calculate and print running averages
        for (int i = 0; i < doublesTestingArray.length; i++) {
            currentSum += doublesTestingArray[i]; // Update sum with the current element
            double avg = currentSum / (i + 1); // Calculate the average
            averages[i] = avg; // Store in averages array
            System.out.println("Position " + i + ": " + String.format("%.2f", avg)); // Print formatted average
        }
        return averages; // Return the array of running averages
    }

    /**
     * Prints the array enclosed in curly braces.
     *
     * @param testingArray the array to print
     */
    public static void printArrayWithCurlyBrace(int[] testingArray) {
        System.out.print("{");
        for (int i = 0; i < testingArray.length; i++) {
            System.out.print(testingArray[i] + ", "); // Print each element followed by a comma
        }
        for (int i = testingArray.length - 2; i < testingArray.length-1; i++) {
            System.out.print(testingArray.length - 1 + "}"); // Close the array with a curly brace
        }
    }

    /**
     * Prints an array of integers in a simple space-separated format.
     *
     * @param testingArray the array to print
     */
    public static void printArray(int[] testingArray) {
        for (int i = 0; i < testingArray.length; i++) {
            System.out.print(testingArray[i] + " "); // Print each element followed by a space
        }
    }

    /**
     * Checks if the array is sorted in ascending order.
     *
     * @param numbers the array to check
     * @return true if the array is sorted, false otherwise
     */
    public static boolean isSorted(int[] numbers) {
        int[] unSort = numbers.clone(); // Clone array to avoid modifying original
        Arrays.sort(unSort); // Sort the cloned array
        return Arrays.equals(unSort, numbers); // Compare sorted array with the original
    }

    public static void main(String[] args) {
        // Test arrays
        int[] testingArray = {4, 2, 7, 1, 9};
        int[] testingArray2 = {1, 2, 3, 4, 5};

        // Test findMinMax method
        int[] result = findMinMax(testingArray);
        System.out.print("Testing with array: ");
        printArrayWithCurlyBrace(testingArray); // Print array in curly braces
        System.out.println("\nMinimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1] + "\n");

        // Test calculateRunningAverages method
        System.out.println("Running averages:");
        calculateRunningAverages(testingArray);

        // Test isSorted method
        System.out.println("\nTesting if arrays are sorted:");
        printArray(testingArray); // Print first test array
        System.out.print("\nnumbers1 is sorted: " + isSorted(testingArray) + "\n"); // Check if first array is sorted

        printArray(testingArray2); // Print second test array
        System.out.print("\nnumbers2 is sorted: " + isSorted(testingArray2)); // Check if second array is sorted
    }
}