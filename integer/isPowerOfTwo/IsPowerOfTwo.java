public class IsPowerOfTwo{
    public static void main(String[] args) {
        IsPowerOfTwo obj = new IsPowerOfTwo();
        int n = 16;
        obj.isPowerOfTwo(n);
        
    }
    public boolean isPowerOfTwo(int n) {
        /**
         * leetcode 231
         * 1: recursive
         */
        // if(n == 1){
        //     return true;
        // }
        // if(n <= 0 || n % 2 == 1)
        //    return false;
        // n = n / 2;
        // return isPowerOfTwo(n);

        /**
         * 2 位运算
         */
        // if(n < 1){
        //     return false;
        // }else if(n == 1){
        //     return true;
        // }
        // int temp = n;
        // int count = 0;
        // while(temp > 1){
        //     temp = temp >> 1;
        //     count++;
        // }
        // temp = 1 << count;
        // if(temp == n){
        //     return true;
        // }
        // return false;
        /**
         * 3 位运算 &
         */
        if(n < 1){
            return false;
        }
        int m = n & (n - 1);
        if(m == 0){
            return true;
        }else return false;

    }
}