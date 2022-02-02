public class MinDistance {
    public static void main(String[] args) {
        MinDistance obj = new MinDistance();
        String word1 = "horse";
        String word2 = "ros";
        int res = obj.minDistance(word1, word2);
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]: 字符串长度长度为i的字符串word1，替换为长度为j的字符串word2的最小操作次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;//add times
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;//delete times
        }
        if(m == 0){
            return dp[0][n];
        }
        if(n == 0){
            return dp[m][0];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {//长度i的下标为i- 1
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;//替换 添加 删除
                }
            }
        }
        return dp[m][n];

    }
}