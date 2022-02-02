public class MaxProfit{
    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices) {
        /**
         * 类似 moveZeroes
         * 求第i天买入的最小值
         * 遍历（第i天买入值 - 第i天买入的最小值）
         */
        int min = 0;
        int n = prices.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(min > prices[i]){
                min = prices[i];
            }
            max = Integer.max(max, prices[i] - min);
        }
        return max;
    }
}
