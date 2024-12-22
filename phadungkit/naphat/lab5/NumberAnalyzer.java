package phadungkit.naphat.lab5;

import java.util.Arrays;

/**
 * A utility class that provides methods for analyzing arrays of numbers.
 *
 * @author Naphat Phadungkit
 * @version 1.0
 */
public class NumberAnalyzer {

    public static int[] findMinMax(int[] testingArray) {
        int[] arrayFindMinMax = testingArray.clone();
        Arrays.sort(arrayFindMinMax);
        int min = arrayFindMinMax[0];
        int max = arrayFindMinMax[arrayFindMinMax.length - 1];

        return new int[]{min, max};
    }

    public static double[] calculateRunningAverages(int[] testingArray) {
        double currentSum = 0;
        double[] averages = new double[testingArray.length];
        int[] findAvg = testingArray.clone();
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
        for (int i = 0; i < testingArray.length - 1; i++) {
            System.out.print(testingArray[i] + ", ");
        }
        for (int i = testingArray.length - 2; i < testingArray.length - 1; i++) {
            System.out.println(testingArray[testingArray.length - 1] + "}");
        }
    }

    public static void printArray(int[] testingArray) {
        for (int i = 0; i < testingArray.length; i++) {
            System.out.print(testingArray[i] + " ");
        }
    }

    public static void printArray2(int[] testingArray2) {
        for (int i = 0; i < testingArray2.length; i++) {
            System.out.print(testingArray2[i] + " ");
        }
    }

    public static boolean isSorted(int[] testingArray) {
        int[] unSort = testingArray.clone();
        Arrays.sort(unSort);
        return Arrays.equals(unSort, testingArray);
    }

    public static void main(String[] args) {
        int[] testingArray = {4, 2, 7, 1, 9};
        int[] testingArray2 = {1, 2, 3, 4, 5};
        System.out.print("Testing with array: ");
        printArrayWithCurlyBrace(testingArray);

        int[] result = findMinMax(testingArray);
        System.out.println("\nMinimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1] + "\n");

        System.out.println("Running averages:");
        calculateRunningAverages(testingArray);

        System.out.println("\nTesting if arrays is sorted:");
        printArray(testingArray);

        System.out.print("\nnumbers1 is sorted: " + isSorted(testingArray) + "\n");
        printArray2(testingArray2);
        System.out.print("\nnumbers2 is sorted: " + isSorted(testingArray2));

    }
}
