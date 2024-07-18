import java.util.*;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Min-heap based on capital required
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-heap based on profit
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Insert all projects into the min-heap based on their capital requirements
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Iterate to select up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with the current capital to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // If no projects can be started, break the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Start the project with the maximum profit
            w += maxProfitHeap.poll()[1];
        }

        return w;
    }

    public static void main(String[] args) {
        IPO solution = new IPO();

        // Example 1
        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        System.out.println("Maximized Capital: " + solution.findMaximizedCapital(k1, w1, profits1, capital1)); // Output: 4

        // Example 2
        int k2 = 3;
        int w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        System.out.println("Maximized Capital: " + solution.findMaximizedCapital(k2, w2, profits2, capital2)); // Output: 6
    }
}


//Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

//You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

//Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

//Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

//The answer is guaranteed to fit in a 32-bit signed integer.