package phadungkit.naphat.lab5;

/**
 * This program is designed to create and manipulate matrices. Users can create
 * a matrix using different options (user input, random, all zeros, all ones, or
 * diagonal). It also provides operations such as finding transpose, summing
 * rows/columns, finding min/max, and displaying diagonal elements.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 23 December 2024
 */
import java.util.Scanner;

public class MatrixOperations {

    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner getData = new Scanner(System.in);

    /**
     * Finds and displays the minimum and maximum elements in the matrix.
     */
    public static void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        // Iterate through each element to find min and max
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }
        }

        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    /**
     * Displays the menu for matrix creation options.
     */
    private static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    /**
     * Creates the matrix based on the user's choice of creation method.
     * Option 1: User inputs values manually.
     * Option 2: Random values between 0-9 are assigned.
     * Option 3: All matrix elements are set to 0.
     * Option 4: All matrix elements are set to 1.
     */
    private static void createMatrix(int choice) {
        if (choice == 1) {
            System.out.println("Enter matrix elements:");
            getData.nextLine(); // Clear buffer
            // Input values manually from the user
            for (int i = 0; i < rows; i++) {
                String[] rowValues = getData.nextLine().split(" ");
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
        } else if (choice == 2) {
            // Randomly populate the matrix with numbers from 0-9
            int min = 0;
            int max = 9;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = min + (int) (Math.random() * ((max - min) + 1));
                }
            }
        } else if (choice == 3) {
            // Fill the matrix with zeros
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        } else if (choice == 4) {
            // Fill the matrix with ones
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    /**
     * Creates a diagonal matrix (only the main diagonal has 1's, all others are 0).
     */
    private static void createDiagonalMatrix() {
        // Set all elements to 0 initially
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
        // Set the diagonal elements to 1
        for (int i = 0; i < rows; i++) {
            matrix[i][i] = 1;
        }
    }

    /**
     * Displays the matrix in a readable format.
     */
    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value); // Print each value in the matrix
            }
            System.out.println();
        }
    }

    /**
     * Displays the operations menu for manipulating the matrix.
     */
    private static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Computes and displays the transpose of the matrix.
     */
    private static void transposeMatrix() {
        int[][] transposedMatrix = new int[columns][rows];
        // Swap rows and columns to transpose
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("\nTransposed Matrix:");
        displayMatrix(transposedMatrix);
    }

    /**
     * Calculates and displays the sum of each row and each column.
     */
    private static void calculateSums() {
        int[] rowSums = new int[rows];
        int[] columnSums = new int[columns];
        // Sum up each row and column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowSums[i] += matrix[i][j];
                columnSums[j] += matrix[i][j];
            }
        }
        // Display the row sums
        System.out.println("\nRow Sums:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + " sum: " + rowSums[i]);
        }
        // Display the column sums
        System.out.println("\nColumn Sums:");
        for (int j = 0; j < columns; j++) {
            System.out.println("Column " + (j + 1) + " sum: " + columnSums[j]);
        }
    }

    /**
     * Displays the diagonal elements of the matrix (if it's square).
     * If the matrix is not square, an error message is displayed.
     */
    private static void displayDiagonal() {
        if (rows == columns) {
            System.out.println("\nDiagonal Matrix:");
            // Print diagonal elements, otherwise 0
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == j) {
                        System.out.printf("%4d", matrix[i][j]);
                    } else {
                        System.out.printf("%4d", 0);
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("\nMatrix is not square. Cannot display diagonal elements.");
        }
    }


    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            int choice = getData.nextInt();

            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = getData.nextInt();
                System.out.print("Enter number of columns: ");
                columns = getData.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns];
                createMatrix(choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = getData.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = getData.nextInt();

                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        getData.close();
    }

}
