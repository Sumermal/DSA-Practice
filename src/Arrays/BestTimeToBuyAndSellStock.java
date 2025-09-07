package Arrays;

public class BestTimeToBuyAndSellStock {

    // Function to calculate the maximum profit
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int mini = prices[0]; // minimum price seen so far (buying price)
        int profit = 0;       // maximum profit we can achieve

        // Traverse prices starting from day 1
        for (int i = 1; i < n; i++) {
            int cost = prices[i] - mini;        // profit if we sell today
            profit = Math.max(profit, cost);    // update maximum profit
            mini = Math.min(mini, prices[i]);   // update minimum price (buying at cheapest)
        }

        return profit; // final maximum profit

        /*Time Complexity: O(n)
            We traverse the array once.

        Space Complexity: O(1)
            Only a few variables (mini, profit, cost).*/
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}