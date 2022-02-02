public class MaxProfitMedium {
    public static void main(String[] args) {
        MaxProfitMedium obj = new MaxProfitMedium();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        obj.maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        // int p = 0;
        int max = 0;
        int min = prices[0];
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            min = Integer.min(min, prices[i]);
            int val = prices[i] - min;
            if (val > 0) {
                max += val;
                if (i == n - 1) {
                    break;
                }
                // p = i + 1;
                min = prices[i];
            }
        }
        return max;
    }
}