public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        // Inicializamos las variables para el menor precio visto hasta ahora y el beneficio máximo
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iteramos sobre el array de precios
        for (int price : prices) {
            // Si encontramos un precio menor, lo actualizamos
            if (price < minPrice) {
                minPrice = price;
            } 
            // Si el beneficio con el precio actual es mayor al máximo beneficio encontrado, lo actualizamos
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        // Devolvemos el máximo beneficio encontrado
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum profit: " + maxProfit(prices));
    }
}


//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock.

//Return the maximum profit you can achieve from this transaction. 
//If you cannot achieve any profit, return 0.