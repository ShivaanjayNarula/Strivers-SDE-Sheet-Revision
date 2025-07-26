class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, 0);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans, int id)
    {
        int n = nums.length;
        if(id == n-1)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i : nums)
            {
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        for(int j = id; j < n; j++)
        {
            swap(nums, id, j);
            helper(nums, ans, id+1);
            swap(nums, id, j);
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
