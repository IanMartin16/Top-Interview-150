public class NQueensII {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        int[] positions = new int[n];
        placeQueens(positions, 0, n);
        return count;
    }

    private void placeQueens(int[] positions, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(positions, row, col)) {
                positions[row] = col;
                placeQueens(positions, row + 1, n);
            }
        }
    }

    private boolean isSafe(int[] positions, int row, int col) {
        for (int i = 0; i < row; i++) {
            int prevCol = positions[i];
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensSolution solution = new NQueensSolution();
        int n = 4;
        int result = solution.totalNQueens(n);
        System.out.println("The number of distinct solutions for " + n + "-queens problem is: " + result);
        // Output: The number of distinct solutions for 4-queens problem is: 2
    }
}


//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

//Given an integer n, return the number of distinct solutions to the n-queens puzzle.