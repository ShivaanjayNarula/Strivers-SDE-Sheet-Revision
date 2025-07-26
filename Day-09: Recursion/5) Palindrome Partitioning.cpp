class Solution {
public:
    vector<vector<string>> partition(string s) {
        int n = s.size();
        vector<vector<string>> ans;
        vector<string> path;
        helper(0, s, path, ans);
        return ans;
    }
    void helper(int i, string &s, vector<string> &path, vector<vector<string>> &ans)
    {
        int n = s.size();
        if(i == n)
        {
            ans.push_back(path);
            return;
        }
        for(int j = i; j < n; j++)
        {
            if(check(s, i, j))
            {
                path.push_back(s.substr(i, j - i + 1));
                helper(j+1, s, path, ans);
                path.pop_back();
            }
        }
    }
    bool check(string &s, int i, int j)
    {
        while(i < j)
        {
            if(s[i] != s[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};
