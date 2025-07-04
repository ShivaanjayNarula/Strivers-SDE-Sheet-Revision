class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> check = new ArrayList<>();
        helper(0, target, check, candidates, ans);
        return ans;
    }
    private void helper(int index, int target, List<Integer> check, int[] nums, List<List<Integer>> ans)
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

            if(i > index && nums[i] == nums[i - 1])
            {
                continue;
            }
            check.add(nums[i]);
            helper(i + 1, target - nums[i], check, nums, ans);
            check.remove(check.size() - 1);
        }
    }
}
