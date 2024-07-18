class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int dir = 0; // 0: left to right, 1: top to bottom, 2: right to left, 3: bottom to top
        
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                // Traverse from left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                // Traverse from top to bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            
            // Update direction
            dir = (dir + 1) % 4;
        }
        
        return result;
    }
}


//Given an m x n matrix, return all elements of the matrix in spiral order.