class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        int n = nums.size();
        long long ans = 0;
        long long check = 0;
        unordered_map<int, int> mp;
        mp[0] = 1;
        for(int i = 0; i < n; i++)
        {
            check ^= nums[i];
            ans += mp[check];
            mp[check]++;
        }
        return ans;
    }
};
