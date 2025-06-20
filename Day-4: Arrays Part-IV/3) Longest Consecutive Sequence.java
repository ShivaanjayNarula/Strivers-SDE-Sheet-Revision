class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
        {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 1;
        int check = 1;
        for(int i = 0; i < n - 1; i++)
        {
            if(nums[i] != nums[i + 1])
            {
                if(nums[i] + 1 == nums[i + 1])
                {
                    check++;
                }
                else
                {
                    ans = Math.max(ans, check);
                    check = 1;
                }
            }
        }
        ans = Math.max(ans, check);
        return ans;
    }
}
