public class Divide {
    public static void main(String[] args) {
        Divide obj = new Divide();
        int dividend = 10;// 2147483647
        int divisor = 3;
        obj.divide(dividend, divisor);

    }

    public int divide(int dividend, int divisor) {
        /**
         * -2^31 <= dividend, divisor <= 2^31 - 1
         * divisor != 0
         */
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend > 0) ^ (divisor > 0);// negtivie: flag = true; positive: flag = true
        long dividend_l = Math.abs((long) dividend);
        long divisor_l = Math.abs((long) divisor);
        return flag ? -helper(dividend_l, divisor_l) : helper(dividend_l, divisor_l);
    }
    public int helper(long dividend, long divisor) {
        /**
         * way1: iteration
         * 1 get dividend/divisor no using /, *, %
         * 2 if (dividend == Integer.MIN_VALUE && divisor == -1) 
         *       then return Integer.MAX_VALUE
         * 3 let flag = (dividend > 0) ^ (divisor > 0), flag is true means the return value is negative, flag is false means the return is possitive
         * 4 let long a equals the absolute value of dividend. long is in case of overflow
         * 5 let long b equals the absolute value of divisor. long is in case of overflow
         * 6 get positive dividend a / positive divisor no using /, *, %
         * 7 let res = 0
         * 8 while (a >= b) do
         *       let temp = b
         *       let k = 1
         *       while (a >= temp << 1) do
         *             temp = temp << 1
         *             k = k << 1
         *       end
         *       let a -= temp
         *       let res += k
         *   end
         *10 the 6 step's value is  res 
         *11 the 1 step's value is flage ? -res : res
         * 
         */
        int res = 0;
        while (dividend >= divisor) {
            long temp = divisor;
            int count = 1;
            while (dividend >= temp << 1) {
                temp = temp << 1;
                count = count << 1;
            }
            dividend -= temp;
            res += count;
        }
        return res;
    }

}