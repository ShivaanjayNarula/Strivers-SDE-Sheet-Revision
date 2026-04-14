class Solution {
    public int reversePairs(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right)
    {
        if(left >= right)
        {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int ans = helper(nums, left, mid) + helper(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int count = mid + 1;
        while(i <= mid)
        {
            while(count <= right && (long) nums[i] > 2L * nums[count])
            {
                count++;
            }
            ans += count - (mid + 1);
            i++;
        }
        List<Integer> merge = new ArrayList<>();
        i = left;
        j = mid + 1;
        while(i <= mid && j <= right)
        {
            if(nums[i] <= nums[j])
            {
                merge.add(nums[i]);
                i++;
            }
            else
            {
                merge.add(nums[j]);
                j++;
            }
        }
        while(i <= mid)
        {
            merge.add(nums[i++]);
        }
        while(j <= right)
        {
            merge.add(nums[j++]);
        }
        for(int k = 0; k < merge.size(); k++)
        {
            nums[left + k] = merge.get(k);
        }
        return ans;
    }
}
