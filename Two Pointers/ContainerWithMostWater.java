public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Mueve el puntero que apunta a la línea más baja
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); // 49

        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); // 1

        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println(solution.maxArea(height3)); // 16

        int[] height4 = {1, 2, 1};
        System.out.println(solution.maxArea(height4)); // 2
    }
}


//You are given an integer array height of length n. 
//There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

//Find two lines that together with the x-axis form a container, 
//such that the container contains the most water.

//Return the maximum amount of water a container can store.