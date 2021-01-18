123. Best Time to Buy and Sell Stock III
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int oneBuyOneSell = 0;
        int oneBuy = Integer.MAX_VALUE;
        int twoBuyTwoSell = 0;
        int twoBuy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            int cur = prices[i];
            oneBuy = Math.min(oneBuy,cur);
            oneBuyOneSell = Math.max(oneBuyOneSell, cur - oneBuy);
            twoBuy = Math.min(twoBuy, cur - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, cur - twoBuy);    
        }
        return twoBuyTwoSell;
    }
}