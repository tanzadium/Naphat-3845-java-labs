package phadungkit.naphat.lab5;

public class RecursiveMethods {

    /**
     * Recursively finds the sum of digits in a number. Example: For the number
     * 123, the answer is 1+2+3 = 6
     *
     * @param number the input number
     * @return sum of digits
     */
    public static int sumOfDigits(int number) {
        // Base case: If the number is 0, return 0 since adding nothing results in 0.
        if (number == 0) {
            return 0;
        } else {
            // Recursive case: Add the last digit (number % 10) to the result of the sum of the remaining digits (number / 10).
            return number % 10 + sumOfDigits(number / 10);
        }
    }
    /**
 	* Recursively reverses an array between start and end indices.
 	* @param arr the array to reverse
 	* @param start starting index
 	* @param end ending index
 	*/
	public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
	}

    /**
 	* Recursively checks if an array is palindrome.
 	* @param arr the array to check
 	* @param start starting index
 	* @param end ending index
 	* @return true if palindrome, false otherwise
 	*/
	public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        }
        return isPalindrome(arr, start + 1, end - 1);
	}


    public static void main(String[] args) {
        int number1 = 456;
        int number2 = 1234;
        int[] arr = {1,2,3,4,5};
        System.out.println("Sum of digits in " + number1 + ": " + sumOfDigits(number1));
        System.out.println("Sum of digits in " + number2 + ": " + sumOfDigits(number2));
        System.out.println("\nOriginal array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nReversed array:");
        reverseArray(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }

        int[] palindromeArray = {1,2,3,4,3,2,1};
        int[] notPalindromeArray = {1,2,1,2,3};
        System.out.println("\n\nTesting palindrome:");
        for (int num : palindromeArray) {
            System.out.print(num + " ");
        }
        System.out.println("\nIs palindrome: " + isPalindrome(palindromeArray, 0 , palindromeArray.length - 1));

        isPalindrome(notPalindromeArray, 0 , notPalindromeArray.length - 1);
        System.out.println("\nTesting palindrome:");
        for (int num : notPalindromeArray) {
            System.out.print(num + " ");
        }
        System.out.println("\nIs palindrome: " + isPalindrome(notPalindromeArray, 0 , notPalindromeArray.length - 1));
    }
}
