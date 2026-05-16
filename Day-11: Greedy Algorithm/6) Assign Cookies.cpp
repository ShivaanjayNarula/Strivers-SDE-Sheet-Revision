class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int m = g.size();
        int n = s.size();
        int ans = 0;
        int left = 0;
        int right = 0;
        while(left < m && right < n)
        {
            if(g[left] <= s[right])
            {
                left++;
                right++;
                ans++;
            }
            else
            {
                right++;
            }
        }
        return ans;
    }
};
