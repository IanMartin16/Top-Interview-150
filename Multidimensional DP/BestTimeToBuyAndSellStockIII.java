public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        // Initialize arrays to store maximum profits
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Compute maximum profit with one transaction from left to right
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Compute maximum profit with one transaction from right to left
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Find the maximum profit achievable with two transactions
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + (i + 1 < n ? rightProfit[i + 1] : 0));
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit); // Output: 6
    }
}


//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//Find the maximum profit you can achieve. You may complete at most two transactions.

//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).