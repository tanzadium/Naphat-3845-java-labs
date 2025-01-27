package phadungkit.naphat.lab7;

/**
 * This class represents an iPad Air device, extending the MobileDevice class.
 * It includes properties specific to iPad Air such as storage capacity and chip type.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class IPadAir extends MobileDevice {

    private double storage;
    private static String CHIP_NAME = "Apple M2";

    /**
     * Constructs a new iPad Air with specified color, price, and storage capacity.
     */
    public IPadAir(String color, double price, double storage) {
        setColor(color);
        setPrice(price);
        setStorage(storage);
    }

    /**
     * Gets the storage capacity of the iPad.
     */
    public double getStorage() {
        return storage;
    }

    /**
     * Sets the storage capacity of the iPad.
     */
    public void setStorage(double storage) {
        this.storage = storage;
    }

    /**
     * Gets the chip name used in the iPad.
     */
    public static String getChip() {
        return CHIP_NAME;
    }

    /**
     * Implements the isWatch method from MobileDevice.
     * Since this is an iPad device, it always returns false.
     */
    @Override
    public boolean isWatch() {
        return false;
    }

    /**
     * Creates a string representation of the iPad Air device.
     * Includes color, price, storage capacity, and chip name.
     */
    @Override
    public String toString() {
        return "IPadAir [color=" + getColor() + ", price=" + getPrice()
                + ", storage=" + storage + ", chip=" + CHIP_NAME + "]";
    }
}