package phadungkit.naphat.lab7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class implements a comparator for sorting mobile devices based on multiple criteria.
 * It sorts devices primarily by price, then by device-specific attributes.
 * For watches, it sorts by model name and color.
 * For iPads, it sorts by storage capacity and color.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class SortMobileDevices implements Comparator<MobileDevice> {

    /**
     * Main method to demonstrate the sorting functionality.
     * Creates an array of mobile devices and sorts them using the implemented comparator.
     */
    public static void main(String[] args) {
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        Arrays.sort(devices, new SortMobileDevices());

        System.out.println("Moblie devices sorted by multiple criteria:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    /**
     * Compares two mobile devices based on multiple criteria.
     * First compares by price, then by device-specific attributes.
     */
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        int priceCompare = Double.compare(device1.getPrice(), device2.getPrice());

        if (priceCompare != 0) {
            return priceCompare;
        }

        if (device1.isWatch() && device2.isWatch()) {
            AppleWatch watch1 = (AppleWatch) device1;
            AppleWatch watch2 = (AppleWatch) device2;

            if (watch1.getModelName().equals(watch2.getModelName())) {
                return watch1.getColor().compareTo(watch2.getColor());
            } else {
                return watch1.getModelName().compareTo(watch2.getModelName());
            }
        } else if (!device1.isWatch() && !device2.isWatch()) {
            IPadAir iPad1 = (IPadAir) device1;
            IPadAir iPad2 = (IPadAir) device2;

            if (iPad1.getStorage() == iPad2.getStorage()) {
                return Double.compare(iPad1.getStorage(), iPad2.getStorage());
            } else {
                return iPad1.getColor().compareTo(iPad2.getColor());
            }
        } else {
            return device1.getColor().compareTo(device2.getColor());
        }
    }
}