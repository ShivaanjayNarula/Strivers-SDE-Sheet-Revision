class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, m, n, dp);
    }
    int helper(int i, int j, int m, int n, int[][] dp)
    {
        if(i == m-1 && j == n-1)
        {
            return 1;
        }
        if(i > m-1 && j > n-1)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        dp[i][j] = helper(i+1, j, m, n, dp) + helper(i, j+1, m, n, dp);
        return dp[i][j];
    }
}
