public class UniquePaths {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        // 1 <= m, n <= 100
        /**
         * leecode 62
         * Time complexity O(m * n)
         */
        // int[][] dp = new int[m][n];
        // // 初始化
        // for (int i = 0; i < m; i++) {
        // dp[i][0] = 1;
        // }
        // for (int i = 0; i < n; i++) {
        // dp[0][i] = 1;
        // }
        // for (int i = 1; i < m; i++) {
        // for (int j = 1; j < n; j++) {
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        // }
        // }
        // return dp[m - 1][n - 1];
        /**
         * time complexity O(n)
         */
        int[] dp = new int[n];// 定义dp
        for (int i = 0; i < n; i++) {// 初始化
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];

        /**
         * Time complexity O(min{m, n})
         */
        // int total = m + n -2;//total steps: m - 1 + n - 1
        // int min_effi = Integer.min(m, n) - 1;//will iterate on the minimum for
        // efficiency: min(right, down)
        // int res = 1;
        // for(int i = 1; i <= min_effi; i++, total--){
        // res = res * total / i;
        // }
        // return res;

    }
}