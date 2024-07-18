public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSquareLen = 0;

        // Initialize dp array with the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxSquareLen = Math.max(maxSquareLen, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxSquareLen = Math.max(maxSquareLen, dp[0][j]);
        }

        // Fill dp array based on previous cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        // Calculate area of the largest square
        int maxArea = maxSquareLen * maxSquareLen;
        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int maxArea = maximalSquare(matrix);
        System.out.println("Largest square area: " + maxArea); // Output: 4
    }
}


//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.