public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2}; // Example input
        int result = singleNumber(nums);
        System.out.println("The single number is: " + result); // Output: 4
    }
}


//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

//You must implement a solution with a linear runtime complexity and use only constant extra space.