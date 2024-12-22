package phadungkit.naphat.lab5;

import java.util.Arrays;

/**
 * A utility class that provides methods for analyzing arrays of numbers.
 *
 * @author Naphat Phadungkit
 * @version 1.0
 */
public class NumberAnalyzer {

    /**
     * Finds the minimum and maximum values in an array of numbers.
     *
     * @param numbers an array of integers
     * @return an array containing the minimum and maximum values
     */
    public static int[] findMinMax(int[] numbers) {
        int[] arrayFindMinMax = numbers.clone();
        Arrays.sort(arrayFindMinMax);
        int min = arrayFindMinMax[0];
        int max = arrayFindMinMax[arrayFindMinMax.length - 1];

        return new int[]{min, max};
    }

    /**
 	* Calculates the running average of numbers up to each position.
 	* For example: input [1,2,3] returns [1.0, 1.5, 2.0]
 	* @param numbers the input array
 	* @return array of running averages
 	*/

    public static double[] calculateRunningAverages(int[] numbers) {
        double currentSum = 0;
        double[] averages = new double[numbers.length];
        int[] findAvg = numbers.clone();
        double[] doublesTestingArray = Arrays.stream(findAvg).asDoubleStream().toArray();
        for (int i = 0; i < doublesTestingArray.length; i++) {
            currentSum += doublesTestingArray[i];
            double avg = currentSum / (i + 1);
            averages[i] = avg;
            System.out.println("Position " + i + ": " + String.format("%.2f", avg));
        }
        return averages;

    }

    public static void printArrayWithCurlyBrace(int[] testingArray) {
        System.out.print("{");
        for (int i = 0; i < testingArray.length; i++) {
            System.out.print(testingArray[i] + ", ");
        }
        for (int i = testingArray.length - 2; i < testingArray.length-1; i++) {
            System.out.print(testingArray.length - 1 + "}");
        }
    }

    public static void printArray(int[] testingArray) {
        for (int i = 0; i < testingArray.length; i++) {
            System.out.print(testingArray[i] + " ");
        }
    }

    /**
 	* Checks if the array is sorted in ascending order.
 	* @param numbers the array to check
 	* @return true if sorted, false otherwise
 	*/

    public static boolean isSorted(int[] numbers) {
        int[] unSort = numbers.clone();
        Arrays.sort(unSort);
        return Arrays.equals(unSort, numbers);
    }

    public static void main(String[] args) {
        int[] testingArray = {4, 2, 7, 1, 9};
        int[] testingArray2 = {1, 2, 3, 4, 5};
        int[] result = findMinMax(testingArray);
        System.out.print("Testing with array: ");
        printArrayWithCurlyBrace(testingArray);
        System.out.println("\nMinimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1] + "\n");

        System.out.println("Running averages:");
        calculateRunningAverages(testingArray);

        System.out.println("\nTesting if arrays are sorted:");
        printArray(testingArray);

        System.out.print("\nnumbers1 is sorted: " + isSorted(testingArray) + "\n");
        printArray(testingArray2);
        System.out.print("\nnumbers2 is sorted: " + isSorted(testingArray2));

    }
}
