import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); // not i + 1 because we can reuse same elements
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);
        System.out.println(combinations);
        // Output: [[2, 2, 3], [7]]
    }
}


//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates 
//where the chosen numbers sum to target. You may return the combinations in any order.

//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
//frequency
// of at least one of the chosen numbers is different.

//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for 
//the given input.