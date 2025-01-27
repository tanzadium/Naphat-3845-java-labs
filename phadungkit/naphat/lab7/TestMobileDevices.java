package phadungkit.naphat.lab7;

/**
 * This class tests the functionality of various mobile devices.
 * It demonstrates the creation and comparison of different mobile devices,
 * specifically iPads and Apple Watches.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class TestMobileDevices {

    /**
     * Main method to test mobile device functionality.
     * Creates different devices and demonstrates their features and comparisons.
     */
    public static void main(String[] args) {
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        
        System.out.println("IPadAir chip name is " + IPadAir.getChip());
        if (ipadAir2.isWatch()) {
            System.out.println(ipadAir2 + " is a watch.");
        } else {
            System.out.println(ipadAir2 + " is not a watch.");
        }
        comparePrice(ipadAir1, ipadAir2);
        comparePrice(ipadAir1, appleWatch1);
    }

    // Compares the prices of two mobile devices and prints the comparison result.
    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        if (device1.getPrice() < device2.getPrice()) {
            System.out.println(device1 + " is cheaper than " + device2);
        } else if (device1.getPrice() > device2.getPrice()) {
            System.out.println(device2 + " is cheaper than " + device1);
        } else {
            System.out.println(device1 + " has the same price as " + device2);
        }
    }
}