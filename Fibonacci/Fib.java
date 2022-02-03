public class Fib {
    public static void main(String[] args) {
        Fib obj = new Fib();
        int n = 3;
        obj.fib(n);
    }

    public int fib(int n) {
        /**
         * ---------1-------------recursive
         * time: O(2^n)
         * space: O(n)
         */
        // if(n == 0){
        // return 0;
        // }
        // if(n == 1){
        // return 1;
        // }
        // return fib(n - 1) + fib(n - 2);
        /**
         * ----2-------dp---
         * time: O(n)
         * space: O(n)
         */
        // if(n == 0){
        //     return 0;
        // }
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i = 2; i <= n; i++ ){
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];
        /**
         * ----3--------------------
         *  Time: O(n), Space: O(1)
         */
        if(n == 0){
        return 0;
        }
        if(n == 1){
        return 1;
        }
        int first = 0, sec = 1;
        for(int i = 2; i <= n; i++){
            int third = first + sec;
            first = sec;
            sec = third;
        }
        return sec;

    }
}