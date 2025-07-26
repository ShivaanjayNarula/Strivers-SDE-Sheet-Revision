class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            nums.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++)
        {
            fact[i] = fact[i - 1] * i;
        }
        k--;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            int id = k / fact[n - i - 1];
            ans.append(nums.get(id));
            nums.remove(id);
            k %= fact[n - i - 1];
        }
        return ans.toString();
    }
}
