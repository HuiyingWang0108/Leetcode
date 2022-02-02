public class Divide2 {
    public static void main(String[] args) {
        Divide2 obj = new Divide2();
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
        return flag ? -helper(dividend_l, divisor_l, 0) : helper(dividend_l, divisor_l, 0);
    }

    public int helper(long dividend, long divisor, int k) {
        /**
         * way2:recursive
         * 1 get dividend/divisor no using /, *, %
         * 2 if (dividend == Integer.MIN_VALUE && divisor == -1) 
         *       then return Integer.MAX_VALUE
         * 3 let flag = (dividend > 0) ^ (divisor > 0), flag is true means the return value is negative, flag is false means the return is possitive
         * 4 let long a equals the absolute value of dividend. long is in case of overflow
         * 5 let long b equals the absolute value of divisor. long is in case of overflow
         * 6 get positive dividend a / positive divisor no using /, *, %
         * 7 a recursive function is helper(a , b, k):
         * 8 let val = k == 0 ? 0 : 1 << k
         * 9 if (a < b) 
         *      then return val
         *      elseif a < b << 1
         *      then return val + 1
         *10 let long temp_a = a in case of overflow
         *11 let long temp_b = b in case of overflow
         *12 let count = 0
         *13 while (temp_a >= temp_b << 1) do
         *         temp_b = temp_b << 1
         *         count++
         *   end
         *14 let new_temp_a = temp_a - temp_b
         *15 return val + helper(new_temp_a, temp_b, count)  
         *16 the 1 step's value is: flag ? -helper(a, b ,0) : helper(a, b ,0)
         */
        int val = k == 0 ? 0 : 1 << k;
        if (dividend < divisor) {
            return val;
        } else if (dividend < divisor << 1) {
            return val = val + 1;
        }
        long temp_dividend = dividend;
        long temp_divisor = divisor;
        int count = 0;
        while (temp_dividend >= temp_divisor << 1) {
            temp_divisor = temp_divisor << 1;
            count++;
        }
        temp_dividend -= temp_divisor;
        return val + helper(temp_dividend, divisor, count);
    }

}