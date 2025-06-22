class Solution {
  public:
    vector<int> subsetSums(vector<int>& arr) {
        // code here
        int n = arr.size();
        vector<int> ans;
        helper(0, 0, arr, ans);
        return ans;
    }
    void helper(int id, int sum, vector<int> &nums, vector<int> &ans)
    {
        int n = nums.size();
        if(id == n)
        {
            ans.push_back(sum);
            return;
        }
        helper(id+1, sum + nums[id], nums, ans);
        helper(id+1, sum, nums, ans);
    }
};
