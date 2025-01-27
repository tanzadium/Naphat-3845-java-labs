package phadungkit.naphat.lab7;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class implements a simple comparator for sorting mobile devices by price.
 * It provides a straightforward way to order devices from lowest to highest price.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class SortMobileDevicesbyPrice implements Comparator<MobileDevice> {

    /**
     * Main method to demonstrate the price-based sorting functionality.
     * Creates an array of mobile devices and sorts them by price.
     */
    public static void main(String[] args) {
        MobileDevice[] devices = new MobileDevice[4];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");

        Arrays.sort(devices, new SortMobileDevicesbyPrice());
        System.out.println("Mobile Devices sorted by price:");

        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    // Compares two mobile devices based solely on their prices.
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {
        return Double.compare(device1.getPrice(), device2.getPrice());
    }
}