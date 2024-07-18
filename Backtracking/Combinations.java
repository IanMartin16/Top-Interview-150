import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4, k = 2;
        List<List<Integer>> combinations = solution.combine(n, k);
        System.out.println(combinations);
        // Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}


//Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

//You may return the answer in any order.