public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        int count = 0;
        
        // Count how many times 5 is a factor in numbers from 1 to n
        while (n > 0) {
            n /= 5;
            count += n;
        }
        
        return count;
    }
    public static void main(String[] args) {
        int n1 = 5; // Example 1: 5! = 120, number of trailing zeroes = 1
        int n2 = 10; // Example 2: 10! = 3628800, number of trailing zeroes = 2
        
        System.out.println("Trailing zeroes in " + n1 + "! : " + trailingZeroes(n1)); // Output: 1
        System.out.println("Trailing zeroes in " + n2 + "! : " + trailingZeroes(n2)); // Output: 2
    }
}


//Given an integer n, return the number of trailing zeroes in n!.

//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.