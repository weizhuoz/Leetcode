322. Coin Change
https://leetcode.com/problems/coin-change/
class Solution {
    /* Use dp[i] to represent the min counts of the coins to get amount i
       dp[0] = 0 and dp[i] = -1 when i<0
       Transfer function :  dp[i] = min{ dp[i-coin] + 1} where coin belongs to coins and i>0
       Answer dp[amount]
    */
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0){return -1;}
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
           dp[i] = Integer.MAX_VALUE - 1;
           for(int coin: coins){
              if(i-coin < 0){
                  continue;
              } 
              dp[i] = Math.min(dp[i], dp[i-coin]+1);
           }
        }
        
        if(dp[amount] == Integer.MAX_VALUE - 1){
            return -1;
        }
        return dp[amount];
    }
}