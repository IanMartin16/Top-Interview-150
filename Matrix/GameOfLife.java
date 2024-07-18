class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        int[][] copyBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for (int[] direction : directions) {
                    int ni = i + direction[0];
                    int nj = j + direction[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && copyBoard[ni][nj] == 1) {
                        liveNeighbors++;
                    }
                }
                
                if (copyBoard[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}


//According to Wikipedia's article: "The Game of Life, also known simply as Life, 
//is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

//The board is made up of an m x n grid of cells, 
//where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
//Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
//using the following four rules (taken from the above Wikipedia article):

//Any live cell with fewer than two live neighbors dies as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population.
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//The next state is created by applying the above rules simultaneously to every cell in the current state, 
//where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.