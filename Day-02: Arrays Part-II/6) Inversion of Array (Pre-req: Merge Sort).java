class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        Arrays.fill(ans, 0);
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = new Pair(nums[i], i);
        }
        mergeSort(arr, 0, n - 1, ans);
        return Arrays.asList(ans);
    }
    private void mergeSort(Pair[] arr, int left, int right, Integer[] ans)
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
    private void merge(Pair[] arr, int left, int mid, int right, Integer[] ans)
  {
        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int countRightSmaller = 0;
        while(i <= mid && j <= right)
        {
            if(arr[i].val <= arr[j].val)
            {
                ans[arr[i].index] += countRightSmaller;
                temp.add(arr[i++]);
            }
            else
            {
                countRightSmaller++;
                temp.add(arr[j++]);
            }
        }
        while(i <= mid)
        {
            ans[arr[i].index] += countRightSmaller;
            temp.add(arr[i++]);
        }
        while(j <= right)
        {
            temp.add(arr[j++]);
        }
        for(int k = left; k <= right; k++)
        {
            arr[k] = temp.get(k - left);
        }
    }
    private static class Pair
    {
        int val;
        int index;

        Pair(int val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }
}
