package phadungkit.naphat.lab7;

/**
 * This interface defines the contract for devices that collect running statistics.
 * It includes functionality for tracking running metrics and heart rate.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public interface RunnerStatsCollector {
    
    //Displays running statistics such as distance covered.
    public void displayRunningStats();

    //Displays heart rate statistics.
    public void displayHeartRate();
}