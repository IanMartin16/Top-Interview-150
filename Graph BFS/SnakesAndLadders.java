class Solution {
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattenedBoard = new int[n * n + 1];
        boolean leftToRight = true;
        int index = 1; 

        for(int i = n - 1; i >= 0; i--) {
            if(leftToRight) {
                for(int j = 0; j < n; j++) {
                    flattenedBoard[index++] = board[i][j];
                }
            } else {
                for(int j = n - 1; j >= 0; j--) {
                    flattenedBoard[index++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.add(1);
        visited[1] = true;
        int moves = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                if(curr == n * n) {
                    return moves;
                }
                for(int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if(next <= n * n && !visited[next]) {
                        visited[next] = true;
                        if(flattenedBoard[next] != -1) {
                            queue.add(flattenedBoard[next]);
                        } else {
                            queue.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public static void main(String [] args) {
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board));
    }
}


//You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a 
//Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

//You start on square 1 of the board. In each move, starting from square curr, do the following: