class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        return helper(nums, 0, n-1);
    }
    int helper(vector<int> &nums, int left, int right)
    {
        if(left >= right)
        {
            return 0;
        }
        int n = nums.size();
        int mid = left + (right - left) / 2;
        int ans = helper(nums, left, mid) + helper(nums, mid+1, right);
        int i = left;
        int j = mid + 1;
        int count = mid + 1;
        while(i <= mid)
        {
            while(count <= right && nums[i] > 2LL * nums[count])
            {
                count++;
            }
            ans += count - (mid + 1);
            i++;
        }
        vector<int> merge;
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right)
        {
            if(nums[i] <= nums[j])
            {
                merge.push_back(nums[i]);
                i++;
            }
            else
            {
                merge.push_back(nums[j]);
                j++;
            }
        }
        while(i <= mid)
        {
            merge.push_back(nums[i++]);
        }
        while(j <= right)
        {
            merge.push_back(nums[j++]);
        }
        for(int k = 0; k < merge.size(); k++)
        {
            nums[left + k] = merge[k];
        }
        return ans;
    }
};
