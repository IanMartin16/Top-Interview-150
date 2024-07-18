public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1}; // Example input
        int result = rob(nums);
        System.out.println("Maximum amount of money you can rob: " + result); // Output: 12
    }
}


//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.