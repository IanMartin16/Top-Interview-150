public class MaxCircularSubarraySum {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        // Case 1: Max subarray sum in non-circular array (using Kadane's algorithm)
        int maxLinear = kadane(nums);
        
        // Case 2: Max subarray sum in circular array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; // Inverting the array elements
        }
        
        // Max subarray sum of the inverted array (minimum subarray sum of the original array)
        int maxInverted = kadane(nums);
        int maxCircular = totalSum + maxInverted; // maxCircular is totalSum - minSubarraySum
        
        // If maxCircular is 0, it means all numbers are negative, we should use maxLinear in that case
        if (maxCircular == 0) {
            return maxLinear;
        }
        
        // The result is the maximum of the two cases
        return Math.max(maxLinear, maxCircular);
    }
    
    private int kadane(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        MaxCircularSubarraySum solution = new MaxCircularSubarraySum();
        
        // Sample test cases
        int[] nums1 = {1, -2, 3, -2};
        System.out.println("Max Circular Subarray Sum: " + solution.maxSubarraySumCircular(nums1)); // Output: 3

        int[] nums2 = {5, -3, 5};
        System.out.println("Max Circular Subarray Sum: " + solution.maxSubarraySumCircular(nums2)); // Output: 10

        int[] nums3 = {-3, -2, -3};
        System.out.println("Max Circular Subarray Sum: " + solution.maxSubarraySumCircular(nums3)); // Output: -2
    }
}


//Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

//A circular array means the end of the array connects to the beginning of the array. Formally, 
//the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

//A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], 
//there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.