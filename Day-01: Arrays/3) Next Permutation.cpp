class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int id = -1;
        for(int i = n-2; i >= 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                id = i;
                break;
            }
        }
        if(id == -1)
        {
            reverse(nums.begin(), nums.end());
            return;
        }
        int temp = -1;
        for(int i = n-1; i >= id+1; i--)
        {
            if(nums[i] > nums[id])
            {
                temp = i;
                break;
            }
        }
        swap(nums[id], nums[temp]);
        reverse(nums.begin() + id + 1, nums.end());
        return;
    }
};
