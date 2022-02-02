public class NumTilings{
    public static void main(String[] args){}
    public int numTilings(int n) {
        int[] dp = new int[n + 1];
        while(n == 0){
            return 0;
        }
        while(n == 1){
            return 1;
        }
        while(n == 2){
            return 2;
        }
        while(n == 3){
            return 5;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++){
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }
}