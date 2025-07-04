class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        int left = 0;
        int right = 0;
        unordered_map<char, int> mp;
        int ans = 0;
        while(right < n)
        {
            if(mp.count(s[right]) == 0 || mp[s[right]] < left)
            {
                mp[s[right]] = right;
                ans = max(ans, right - left + 1);
            }
            else
            {
                left = mp[s[right]] + 1;
                mp[s[right]] = right;
            }
            right++;
        }
        return ans;
    }
};
