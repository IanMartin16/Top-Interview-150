public class Sqrt {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid^2 is less than or equal to x
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        int x1 = 4; // Example 1: sqrt(4) = 2
        int x2 = 8; // Example 2: sqrt(8) = 2
        
        System.out.println("Square root of " + x1 + " is: " + mySqrt(x1)); // Output: 2
        System.out.println("Square root of " + x2 + " is: " + mySqrt(x2)); // Output: 2
    }
}


//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
//The returned integer should be non-negative as well.

//You must not use any built-in exponent function or operator.