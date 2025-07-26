class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> ans;
        helper(0, nums, ans);
        return ans;
    }
    void helper(int id, vector<int> &nums, vector<vector<int>> &ans)
    {
        int n = nums.size();
        if(id == n)
        {
            ans.push_back(nums);
            return;
        }
        for(int i = id; i < n; i++)
        {
            swap(nums[id], nums[i]);
            helper(id+1, nums, ans);
            swap(nums[id], nums[i]);
        }
    }
};
