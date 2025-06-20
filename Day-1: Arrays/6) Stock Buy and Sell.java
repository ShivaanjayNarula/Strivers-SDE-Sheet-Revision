class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int check = prices[0];
        for(int i = 0; i < n; i++)
        {
            int sum = prices[i] - check;
            ans = Math.max(ans, sum);
            check = Math.min(check, prices[i]);
        }
        return ans;
    }
}
