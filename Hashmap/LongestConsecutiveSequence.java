import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : nums) {
            if (!set.contains(num - 1)) { // Only start counting if it's the start of a sequence
                int currentNum = num;
                int currentStreak = 1;
                
                while (set.contains(currentNum + 1)) { // Extend the sequence
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums)); // Output: 4 (because the longest consecutive sequence is [1, 2, 3, 4])
    }
}


//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

//You must write an algorithm that runs in O(n) time.