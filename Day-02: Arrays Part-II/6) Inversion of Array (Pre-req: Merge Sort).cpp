class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0);
        vector<pair<int, int>> arr;
        for(int i = 0; i < n; ++i)
        {
            arr.push_back({nums[i], i});
        }
        mergeSort(arr, 0, n - 1, ans);
        return ans;
    }
    void mergeSort(vector<pair<int, int>>& arr, int left, int right, vector<int>& ans)
    {
        if(left >= right)
        {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, ans);
        mergeSort(arr, mid + 1, right, ans);
        merge(arr, left, mid, right, ans);
    }
    void merge(vector<pair<int, int>>& arr, int left, int mid, int right, vector<int>& ans)
    {
        vector<pair<int, int>> temp;
        int i = left, j = mid + 1;
        int countRightSmaller = 0;
        while(i <= mid && j <= right)
        {
            if(arr[i].first <= arr[j].first)
            {
                ans[arr[i].second] += countRightSmaller;
                temp.push_back(arr[i++]);
            }
            else
            {
                countRightSmaller++;
                temp.push_back(arr[j++]);
            }
        }
        while(i <= mid)
        {
            ans[arr[i].second] += countRightSmaller;
            temp.push_back(arr[i++]);
        }
        while(j <= right)
        {
            temp.push_back(arr[j++]);
        }
        for(int k = left; k <= right; ++k)
        {
            arr[k] = temp[k - left];
        }
    }
};
