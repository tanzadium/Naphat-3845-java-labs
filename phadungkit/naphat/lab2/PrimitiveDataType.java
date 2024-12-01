package phadungkit.naphat.lab2;

/* 
 * Author: Naphat Phadungkit
 * Student Number: 673040384-5
 * Description: This program demonstrates the use of primitive data types in Java. 
 *              It declares variables of various primitive types, assigns values. 
 * Last updated date: 2 December 2024
 */
public class PrimitiveDataType {

    public static void main(String[] args) {

        // Declare a string to hold the student number
        String studentNumber = "673040384-5";
        System.out.println("Student ID : " + studentNumber);

        // Declare a string to hold the first name
        String firstName = "Naphat";
        System.out.println("First name : " + firstName);

        // Convert int to string and string to byte
        byte myByte = Byte.parseByte(Integer.toString(firstName.length()));
        System.out.println("Byte Value: " + myByte);

        // Declare a short variable and assign a value
        short myShort = 126;
        System.out.println("Short Value: " + myShort);

        // Declare an int variable and assign a value
        int myInt = 403845;
        System.out.println("Int Value: " + myInt);

        // Declare a long variable and assign a value
        long myLong = 6730403845L;
        System.out.println("Long Value: " + myLong);

        // Perform a division using myByte and assign the result to a float
        float myFloat = (myByte / 10);
        System.out.println("Float Value: " + myFloat);

        // Declare a double variable and assign a value
        double myDouble = 0.3845;
        System.out.println("Double Value: " + myDouble);

        // Declare a char variable and assign a value
        char myChar = 'N';
        System.out.println("Char Value: " + myChar);

        // Declare a boolean variable and assign a value
        boolean myBoolean = true;
        System.out.println("Boolean Value: " + myBoolean);
    }
}
