class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        int n = candidates.size();
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> check = {};
        helper(0, target, candidates, ans, check);
        return ans;
    }
    void helper(int id, int target, vector<int> &nums, vector<vector<int>> &ans, vector<int> &check)
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
            check.push_back(nums[i]);
            helper(i, target - nums[i], nums, ans, check);
            check.pop_back();
        }
    }
};
