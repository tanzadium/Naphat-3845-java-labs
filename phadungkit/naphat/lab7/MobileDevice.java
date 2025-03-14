package phadungkit.naphat.lab7;

import java.io.Serializable;

/**
 * This abstract class serves as the base class for all mobile devices.
 * It defines common properties like color and price, and abstract methods
 * that all mobile devices must implement.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public abstract class MobileDevice implements Serializable{
    protected String color;
    protected double price;
    private static final long serialVersionUID = 1L;

    //Gets the color of the device.
    public String getColor() {
        return color;
    }

    //Sets the color of the device.
    public void setColor(String color) {
        this.color = color;
    }

    //Gets the price of the device.
    public double getPrice() {
        return price;   
    }

    //Sets the price of the device.
    public void setPrice(double price) {
        this.price = price;
    }

    //Determines if the device is a watch. Must be implemented by subclasses.
    public abstract boolean isWatch();

    //Creates a string representation of the device. Must be implemented by subclasses.
    public abstract String toString();
}