class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<int[]> jobs = new ArrayList<>();
        int maxDeadline = 0;
        for(int i = 0; i < n; i++)
        {
            jobs.add(new int[]{deadline[i], profit[i]});
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        jobs.sort((a, b) -> {
            if(a[1] == b[1])
            {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int countJobs = 0;
        int totalProfit = 0;
        int[] slots = new int[maxDeadline + 1];
        for(int i = 0; i < n; i++)
        {
            int currentDeadline = jobs.get(i)[0];
            int currentProfit = jobs.get(i)[1];
            for(int j = currentDeadline; j > 0; j--)
            {
                if(slots[j] == 0)
                {
                    slots[j] = 1;
                    countJobs++;
                    totalProfit += currentProfit;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(totalProfit);
        return result;
    }
}
