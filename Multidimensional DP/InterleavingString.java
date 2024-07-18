public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // Check lengths first
        if (m + n != s3.length()) {
            return false;
        }
        
        // dp[i][j] will be true if s3[0...i+j-1] is an interleaving of s1[0...i-1] and s2[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Initialize dp array
        dp[0][0] = true;
        
        // Initialize first row (s2 matches)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Initialize first column (s1 matches)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        
        boolean result = isInterleave(s1, s2, s3);
        System.out.println("Is s3 formed by interleaving s1 and s2? " + result); // Output: true
    }
}


//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

//An interleaving of two strings s and t is a configuration where s and t are divided into n and m 
//substrings
// respectively, such that: