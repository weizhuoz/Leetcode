188. Best Time to Buy and Sell Stock IV
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
class Solution {
    // reuse the idea of the 
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        // if k >= n/2, then you can make maximum number of transactions
        if (k >= prices.length / 2) { 
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            return profit;
        }
        for(int price : prices){
            for(int i=1;i<=k;i++){
                buy[i] = Math.min(buy[i],price-sell[i-1]);
                sell[i] = Math.max(sell[i],price - buy[i]);
            }
        }
        return sell[k];
    }
}