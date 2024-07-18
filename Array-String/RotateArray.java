public class RotateArray {
    public static void rotate(int[] nums, int k) {
        // Reduce k to the equivalent number of steps within the length of the array
        k = k % nums.length;

        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        rotate(nums, k);

        System.out.println("\nArray after rotation:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.