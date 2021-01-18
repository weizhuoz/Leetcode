121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
/*
  Brute Force
  we want to find max(prices[j]-prices[i]), and j>i
  Time Complexity - O(n^2) Time Complexity - O(1)
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
*/
class Solution {
    public int maxProfit(int prices[]) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minValue){
                minValue = prices[i];
            }
            else if((prices[i] - minValue) > res){
                res = prices[i] - minValue;
            }
        }
        return res;
    }
}