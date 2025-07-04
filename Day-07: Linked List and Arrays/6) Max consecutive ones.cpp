class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 1)
            {
                count++;
                ans = max(ans, count);
            }
            else
            {
                count = 0;
            }
        }
        ans = max(ans, count);
        return ans;
    }
};
