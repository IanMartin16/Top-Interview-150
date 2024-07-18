class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Check arrays for rows, columns, and 3x3 sub-boxes
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];
        
        // Traverse the board cell by cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int digit = board[row][col] - '1'; // Convert char to index (0-8)
                    int boxIndex = (row / 3) * 3 + (col / 3); // Calculate box index
                    
                    // Check if digit already exists in current row, column, or box
                    if (rowCheck[row][digit] || colCheck[col][digit] || boxCheck[boxIndex][digit]) {
                        return false; // Invalid Sudoku
                    }
                    
                    // Mark digit as seen in respective checks
                    rowCheck[row][digit] = true;
                    colCheck[col][digit] = true;
                    boxCheck[boxIndex][digit] = true;
                }
            }
        }
        
        return true; // Valid Sudoku
    }
}


//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:

//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.