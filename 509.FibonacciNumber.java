509. Fibonacci Number
https://leetcode.com/problems/fibonacci-number/
// DP solution - Space - O(n) Time O(n)
/*class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return memorize(n);
    }
    
    public int memorize(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
*/
// Recursion - Time complexity : O(2^N) Space complexity : O(N)
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}