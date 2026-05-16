class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        while(left < m && right < n)
        {
            if(g[left] <= s[right])
            {
                ans++;
                left++;
                right++;
            }
            else
            {
                right++;
            }
        }
        return ans;
    }
}
