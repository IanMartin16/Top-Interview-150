public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // Special case: negative numbers and numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > 0) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        // x is now 0, compare reversedNumber with the original number
        return originalNumber == reversedNumber;
    }
    public static void main(String[] args) {
        int x = 121;
        boolean isPalindrome = isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + isPalindrome); // Output: true
    }
}


//Given an integer x, return true if x is a palindrome, and false otherwise.