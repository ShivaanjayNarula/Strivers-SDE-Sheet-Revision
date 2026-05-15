class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i < n+1; i++)
        {
            for(int j = 0; j < amount+1; j++)
            {
                dp[i][j] = -1;
            }
        }
        int ans = helper(coins, amount, 0, dp);
        if(ans == Integer.MAX_VALUE - 1)
        {
            return -1;
        }
        return ans;
    }
    public int helper(int[] coins, int amount, int id, int[][] dp)
    {
        int n = coins.length;
        if(id >= n || amount <= 0)
        {
            if(amount == 0)
            {
                return 0;
            }
            return Integer.MAX_VALUE-1;
        }
        if(dp[id][amount] != -1)
        {
            return dp[id][amount];
        }
        if(coins[id] > amount)
        {
            dp[id][amount] = helper(coins, amount, id+1, dp);
        }
        else
        {
            int take = 1 + helper(coins, amount - coins[id], id, dp);
            int notake = helper(coins, amount, id+1, dp);
            dp[id][amount] = Math.min(take, notake);
        }
        return dp[id][amount];
    }
}
