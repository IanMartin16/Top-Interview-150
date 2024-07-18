import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Add one to the current digit
            digits[i]++;

            // If the digit becomes less than 10, no need to carry over, return digits
            if (digits[i] < 10) {
                return digits;
            }

            // If the digit is 10, set it to 0 and carry over 1 to the next digit
            digits[i] = 0;
        }

        // If we're here, it means all digits were 9's (like [9, 9, 9])
        // In this case, we need to add an extra digit '1' at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;

        return newDigits;
    }
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3}; // Example 1: [1, 2, 3] + 1 = [1, 2, 4]
        int[] digits2 = {9, 9, 9}; // Example 2: [9, 9, 9] + 1 = [1, 0, 0, 0]

        int[] result1 = plusOne(digits1);
        System.out.println("Result 1: " + Arrays.toString(result1)); // Output: [1, 2, 4]

        int[] result2 = plusOne(digits2);
        System.out.println("Result 2: " + Arrays.toString(result2)); // Output: [1, 0, 0, 0]
    }
}


//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
//The digits are ordered from most significant to least significant in left-to-right order. 
//The large integer does not contain any leading 0's.

//Increment the large integer by one and return the resulting array of digits.