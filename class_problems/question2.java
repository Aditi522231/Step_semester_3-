package class_problems;

public class question2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Track lowest price seen so far
        int maxProfit = 0;               // Track maximum profit found

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update the minimum price seen so far
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // Calculate profit if sold today and update max profit
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        question2 q2 = new question2();

        // Sample Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Output 1: " + q2.maxProfit(prices1)); 
        // Expected: 5 (buy at 1, sell at 6)

        // Sample Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Output 2: " + q2.maxProfit(prices2)); 
        // Expected: 0 (no profitable trade)
    }
}