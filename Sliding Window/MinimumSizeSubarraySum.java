public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Casos de prueba
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println(solution.minSubArrayLen(target1, nums1)); // 2 (subarray: [4, 3])

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println(solution.minSubArrayLen(target2, nums2)); // 1 (subarray: [4])

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println(solution.minSubArrayLen(target3, nums3)); // 0 (no subarray sum >= 11)
    }
}


//Given an array of positive integers nums and a positive integer target, return the minimal length of a 
//subarray
 //whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.