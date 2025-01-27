package phadungkit.naphat.lab7;

/**
 * This class tests the functionality of the AppleWatchNike class.
 * It demonstrates creating an AppleWatchNike object and testing its various
 * methods for displaying health and fitness metrics.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class TestAppleWatchNike {
    /**
     * Main method to test AppleWatchNike functionality.
     * Creates a watch instance and tests its various features.
     */
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, 
                                                     "Nike SE GPS", 42.5, 75, 7.50);

        System.out.println(nikeWatch);

        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRate();
        nikeWatch.displaySleepHours();

        System.out.println("Is it a watch? " + nikeWatch.isWatch());
        AppleWatchNike baseWatch = nikeWatch;
        System.out.println("Through base reference: " + baseWatch);
    }
}