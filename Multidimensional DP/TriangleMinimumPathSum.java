import java.util.List;

public class TriangleMinimumPathSum {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize dp array with the bottom row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up approach to calculate minimum path sum
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        ); // Example input
        
        int result = minimumTotal(triangle);
        System.out.println("Minimum path sum from top to bottom: " + result); // Output: 11
    }
}


//Given a triangle array, return the minimum path sum from top to bottom.

//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, 
//you may move to either index i or index i + 1 on the next row.