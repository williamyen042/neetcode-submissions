class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for(int stocks : prices) {
            max = Math.max(max, stocks - min);
            min = Math.min(stocks, min);
        }
        return max;
    }
}
