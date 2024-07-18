public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Step 1: Clean the input string by removing non-alphanumeric characters and converting to lowercase
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check if the cleaned string is a palindrome
        String cleanedString = cleaned.toString();
        int left = 0;
        int right = cleanedString.length() - 1;
        
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car")); // false
        System.out.println(solution.isPalindrome(" ")); // true
    }
}


//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing 
//all non-alphanumeric characters, it reads the same forward and backward. 
//Alphanumeric characters include letters and numbers.

//Given a string s, return true if it is a palindrome, or false otherwise.