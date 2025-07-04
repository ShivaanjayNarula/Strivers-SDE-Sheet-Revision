class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        if(n == 0)
        {
            return 0;
        }
        int ans = 1;
        int check = 1;
        for(int i = 0; i < n-1; i++)
        {
            if(nums[i] != nums[i+1])
            {
                if(nums[i] + 1 == nums[i+1])
                {
                    check++;
                }
                else
                {
                    ans = max(ans, check);
                    check = 1;
                }
            }
        }
        ans = max(ans, check);
        return ans;
    }
};
