public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum obj = new MinPathSum();
        int[][] grid = { { 1, 2, 5 }, { 3, 2, 1 } };// [[1,2,5],[3,2,1]]
        int res = obj.minPathSum(grid);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        // 1 <= m, n <= 200
        int m = grid.length;
        int n = grid[m - 1].length;
        int[][] dp = new int[m][n];
        int row_sum = 0, col_sum = 0;
        for (int i = 0; i < m; i++) {
            row_sum += grid[i][0];
            dp[i][0] = row_sum;
        }
        for (int i = 0; i < n; i++) {
            col_sum += grid[0][i];
            dp[0][i] = col_sum;
        }
        if (n == 1) {
            return dp[m - 1][0];
        }
        if (m == 1) {
            return dp[0][n - 1];
        }

        dp[1][0] = grid[0][0] + grid[1][0];
        dp[0][1] = grid[0][0] + grid[0][1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];

    }
}