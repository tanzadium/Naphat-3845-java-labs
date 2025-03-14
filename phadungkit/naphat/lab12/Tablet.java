package phadungkit.naphat.lab12;

import java.io.*;
import phadungkit.naphat.lab7.MobileDevice;

/**
 * Class representing a tablet, a type of mobile device. Implements concrete
 * methods for the abstract MobileDevice class.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 14 March 2025
 */
public class Tablet extends MobileDevice implements Serializable {

    private static final long serialVersionUID = 1L; // Required for Serializable
    private static String type = "Tablet";
    private String name;
    private String brand;

    public Tablet(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        setPrice(price);
        setColor(color);
    }

    public Tablet(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static String getType() {
        return type;
    }

    @Override
    public boolean isWatch() {
        return false;
    }

    @Override
    public String toString() {
        return type + ": " + name + " (" + brand + ") " + getPrice() + " Baht";
    }
}
