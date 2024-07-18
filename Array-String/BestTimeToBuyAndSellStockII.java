public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Iteramos sobre el array de precios desde el segundo día
        for (int i = 1; i < prices.length; i++) {
            // Si el precio del día actual es mayor que el precio del día anterior, sumamos la diferencia al beneficio total
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        // Devolvemos el beneficio máximo encontrado
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}


// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

//On each day, you may decide to buy and/or sell the stock. 
//You can only hold at most one share of the stock at any time. 
//However, you can buy it then immediately sell it on the same day.

//Find and return the maximum profit you can achieve.