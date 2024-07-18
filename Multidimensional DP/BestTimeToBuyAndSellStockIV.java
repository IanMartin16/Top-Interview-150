public class BestTimeToBuyAndSellStockIV {

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        
        // If k is large enough, problem reduces to the maximum profit with unlimited transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        // Create dp arrays to store maximum profits
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        
        // Initialize dp arrays
        Arrays.fill(buy, Integer.MIN_VALUE);
        
        // Iterate through each price
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        
        return sell[k];
    }
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int maxProfit = maxProfit(k, prices);
        System.out.println("Maximum profit: " + maxProfit); // Output: 7
    }
}


//You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

//Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).