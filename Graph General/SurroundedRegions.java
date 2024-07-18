public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark the 'O' regions connected to the border
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Step 2: Traverse the matrix to flip the 'O's and revert markings
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded 'O' to 'X'
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O'; // Border-connected 'O' back to 'O'
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'E'; // Mark this 'O' as visited

        // Visit all adjacent cells (up, down, left, right)
        dfs(board, i - 1, j); // up
        dfs(board, i + 1, j); // down
        dfs(board, i, j - 1); // left
        dfs(board, i, j + 1); // right
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected output:
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, O, X, X]
    }
}


//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

//Connect: A cell is connected to adjacent cells horizontally or vertically.
//Region: To form a region connect every 'O' cell.
//Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' 
//cells and none of the region cells are on the edge of the board.
//A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.