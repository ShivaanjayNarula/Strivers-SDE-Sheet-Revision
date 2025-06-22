class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> ans = {{}};
        sort(nums.begin(), nums.end());
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
            {
                start = end;
            }
            else
            {
                start = 0;
            }
            end = ans.size();
            for(int j = start; j < end; j++)
            {
                vector<int> temp = ans[j];
                temp.push_back(nums[i]);
                ans.push_back(temp);
            }
        }
        return ans;
    }
};
