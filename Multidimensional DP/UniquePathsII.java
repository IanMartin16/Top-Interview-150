public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a dp array to store the number of unique paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the top-left corner
        dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Initialize the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i-1][0] > 0) {
                dp[i][0] = dp[i-1][0];
            }
        }

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j-1] > 0) {
                dp[0][j] = dp[0][j-1];
            }
        }

        // Fill the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        // Return the number of unique paths to the bottom-right corner
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        }; // Example input
        
        int result = uniquePathsWithObstacles(grid);
        System.out.println("Number of unique paths: " + result); // Output: 2
    }
}


//You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
//The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
//The robot can only move either down or right at any point in time.

//An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

//Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//The testcases are generated so that the answer will be less than or equal to 2 * 109.