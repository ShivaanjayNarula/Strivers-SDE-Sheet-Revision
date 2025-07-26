class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        vector<int> dp(n+1, -1);
        return helper(0, s, wordDict, dp);
    }
    int helper(int id, string &s, vector<string> &wordDict, vector<int> &dp)
    {
        int n = s.size();
        if(id == n)
        {
            return 1;
        }
        if(dp[id] != -1)
        {
            return dp[id];
        }
        for(string word : wordDict)
        {
            int len = word.size();
            if(id + len <= n && s.substr(id, len) == word)
            {
                if(helper(id + len, s, wordDict, dp) == 1)
                {
                    dp[id] = 1;
                    return dp[id];
                }
            }
        }
        dp[id] = 0;
        return dp[id];
    }
};
