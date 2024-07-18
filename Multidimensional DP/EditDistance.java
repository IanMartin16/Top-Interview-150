public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D array to store minimum operations
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Minimum operations to convert word1[0...i-1] to empty string word2[0...0] is i deletions
        }
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Minimum operations to convert empty string word1[0...0] to word2[0...j-1] is j insertions
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no additional operation needed
                } else {
                    // Take the minimum of insert, delete, or replace operation
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        
        int result = minDistance(word1, word2);
        System.out.println("Minimum number of operations: " + result); // Output: 3
    }
}


//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

//You have the following three operations permitted on a word:

//Insert a character
//Delete a character
//Replace a character