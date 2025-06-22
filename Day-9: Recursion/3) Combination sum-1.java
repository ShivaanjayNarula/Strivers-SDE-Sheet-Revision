class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> check = new ArrayList<>();
        helper(0, target, candidates, ans, check);
        return ans;
    }
    private void helper(int index, int target, int[] nums, List<List<Integer>> ans, List<Integer> check)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(check));
            return;
        }
        for(int i = index; i < nums.length; i++)
        {
            if(nums[i] > target)
            {
                break;
            }
            check.add(nums[i]);
            helper(i, target - nums[i], nums, ans, check);
            check.remove(check.size() - 1);
        }
    }
}
