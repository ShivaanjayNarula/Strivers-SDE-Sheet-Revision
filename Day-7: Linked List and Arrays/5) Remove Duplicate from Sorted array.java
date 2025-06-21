class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for(int i = 1; i < n; i++)
        {
            if(nums[i] != nums[i - 1])
            {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
