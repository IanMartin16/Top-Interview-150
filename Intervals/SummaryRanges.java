import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Initialize the start and end of the first range
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // Extend the current range
                end = nums[i];
            } else {
                // Finalize the current range and start a new one
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range to the result
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = solution.summaryRanges(nums);
        System.out.println(result);  // Output: ["0->2", "4->5", "7"]
    }
}


//You are given a sorted unique integer array nums.

//A range [a,b] is the set of all integers from a to b (inclusive).

//Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
//That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.