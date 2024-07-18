import java.util.HashMap;
import java.util.Map;

class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a hashmap to store number and its last seen index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Check if num has been seen before within distance k
            if (map.containsKey(num)) {
                int prevIndex = map.get(num);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            
            // Update the index of the current number
            map.put(num, i);
        }
        
        // No such pair found within distance k
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k)); // Output: true
    }
}


//Given an integer array nums and an integer k, return true if there are two distinct indices 
//i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.