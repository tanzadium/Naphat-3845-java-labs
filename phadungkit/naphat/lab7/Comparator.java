package phadungkit.naphat.lab7;

/**
 * This interface defines a comparison contract for MobileDevice objects.
 * It provides a method to compare two mobile devices based on specific criteria.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public interface Comparator {
    
    //Compares two MobileDevice objects for ordering.
    public int compare(MobileDevice device1, MobileDevice device2);
}