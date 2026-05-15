class Solution {
    // Helper class to store Item properties
    static class Item
    {
        int value;
        int weight;
        double ratio;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / (double) weight;
        }
    }
    public double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++)
        {
            items[i] = new Item(val.get(i), wt.get(i));
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double res = 0.0;
        int currentCapacity = capacity;
        for(int i = 0; i < n; i++)
        {
            if(items[i].weight <= currentCapacity)
            {
                res += items[i].value;
                currentCapacity -= items[i].weight;
            }
            else
            {
                res += items[i].ratio * currentCapacity;
                break;
            }
        }
        return res;
    }
}
