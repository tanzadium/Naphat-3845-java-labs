package phadungkit.naphat.lab2;

/**
* The Dealer Program:
* This program accepts three arguments then processes
* and displays dealer information.
* The output should be
* Dealer's name : <dealer_name>.
* Number of clients : <num_clients>
* Gender : <dealer_gender>
*
* Author : Naphat Phadungkit
* Student ID : 673040384-5
* Sec : 1
* Last updated date: 25 November 2024
*/

public class Dealer {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Invalid number of arguments. Please provide exactly three arguments.");
        }

        else {

            String name = args[0]; //Dealer's name
            String number = args[1]; // Number of clients
            String gender = args[2]; // Dealer's gender

            System.out.println("Dealer's name: " + name);
            System.out.println("Number of clients: " + number);
            System.out.println("Gender: " + gender);
        }
    }
}