class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int ans = 0;
        int check = prices[0];
        for(int i = 0; i < n; i++)
        {
            int sum = prices[i] - check;
            ans = max(sum, ans);
            check = min(check, prices[i]);
        }
        return ans;
    }
};
