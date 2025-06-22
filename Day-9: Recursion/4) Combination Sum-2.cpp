class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        int n = candidates.size();
        vector<vector<int>> ans;
        sort(candidates.begin(), candidates.end());
        vector<int> check = {};
        helper(0, target, check, candidates, ans);
        return ans;
    }
    void helper(int id, int target, vector<int> &check, vector<int> &nums, vector<vector<int>> &ans)
    {
        int n = nums.size();
        if(target == 0)
        {
            ans.push_back(check);
            return;
        }
        for(int i = id; i < n; i++)
        {
            if(nums[i] > target)
            {
                break;
            }
            if(i > id && nums[i] == nums[i-1])
            {
                continue;
            }
            check.push_back(nums[i]);
            helper(i+1, target - nums[i], check, nums, ans);
            check.pop_back();
        }
    }
};
