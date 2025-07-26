class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, s, wordDict, dp) == 1;
    }
    public int helper(int idx, String s, List<String> wordDict, int[] dp)
    {
        int n = s.length();
        if(idx == n)
        {
            return 1;
        }
        if(dp[idx] != -1)
        {
            return dp[idx];
        }
        for(String word : wordDict)
        {
            int len = word.length();
            if(idx + len <= n && s.substring(idx, idx + len).equals(word))
            {
                if(helper(idx + len, s, wordDict, dp) == 1)
                {
                    dp[idx] = 1;
                    return 1;
                }
            }
        }
        dp[idx] = 0;
        return 0;
    }
}
