class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0, s, path, ans);
        return ans;
    }
    public void helper(int i, String s, List<String> path, List<List<String>> ans)
    {
        int n = s.length();
        if(i == n)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < n; j++)
        {
            if(check(s, i, j))
            {
                path.add(s.substring(i, j + 1));
                helper(j + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean check(String s, int i, int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
