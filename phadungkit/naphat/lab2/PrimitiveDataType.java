package phadungkit.naphat.lab2;

/* To demonstrate your understanding of variable declaration, assignment, and output.
 * 
 * Author: Naphat Phadungkit
 * Student Number: 673040384-5
 * Last updated date: 25 November 2024
 */

public class PrimitiveDataType {
    public static void main(String[] args) {

        String studentNumber = "673040384-5";
        System.out.println("Student ID : " + studentNumber);
        String firstName = "Naphat";
        System.out.println("First name : " + firstName);
        byte myByte = Byte.parseByte(Integer.toString(firstName.length()));
        System.out.println("Byte Value: " + myByte);
        short myShort = 126;
        System.out.println("Short Value: " + myShort);
        int myInt = 403845;
        System.out.println("Int Value: " + myInt);
        long myLong = 6730403845L;
        System.out.println("Long Value: " + myLong);
        float myFloat = (myByte/10);
        System.out.println("Float Value: " + myFloat);
        double myDouble = 0.3845;
        System.out.println("Double Value: " +  myDouble);
        char myChar = 'N';
        System.out.println("Char Value: " + myChar);
        boolean myBoolean = true;
        System.out.println("Boolean Value: " + myBoolean);

    }
}
