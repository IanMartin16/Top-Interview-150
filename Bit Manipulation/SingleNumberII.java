public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int[] bitCount = new int[32]; // There are 32 bits in an integer

        // Count the number of 1s in each bit position
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCount[i] += (num >> i) & 1;
            }
        }

        // Reconstruct the single number
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2}; // Example input
        int result = singleNumber(nums);
        System.out.println("The single number is: " + result); // Output: 3
    }
}


//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

//You must implement a solution with a linear runtime complexity and use only constant extra space