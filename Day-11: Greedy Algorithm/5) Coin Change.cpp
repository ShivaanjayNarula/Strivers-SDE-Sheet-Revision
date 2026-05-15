class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n+1, vector<int>(amount+1, -1));
        int ans =  helper(0, coins, amount, dp);
        if(ans == INT_MAX - 1)
        {
            return -1;
        }
        return ans;
    }
    int helper(int id, vector<int> &coins, int amount, vector<vector<int>> &dp)
    {
        int n = coins.size();
        if(id >= n || amount <= 0)
        {
            if(amount == 0)
            {
                return 0;
            }
            return INT_MAX-1;
        }
        if(dp[id][amount] != -1)
        {
            return dp[id][amount];
        }
        if(coins[id] > amount)
        {
            int notake = helper(id+1, coins, amount, dp);
            dp[id][amount] = notake;
        }
        else
        {
            int take = 1 + helper(id, coins, amount - coins[id], dp);
            int notake = helper(id+1, coins, amount, dp);
            dp[id][amount] = min(take, notake);
        }
        return dp[id][amount];
    }
};
