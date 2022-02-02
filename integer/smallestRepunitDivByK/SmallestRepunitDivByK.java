public class SmallestRepunitDivByK{
    public static void main(String[] args) {
        int k = 17;
        SmallestRepunitDivByK obj = new SmallestRepunitDivByK();
        obj.smallestRepunitDivByK(k);
        
    }
    public int smallestRepunitDivByK(int k) {
        /**
         * leetcode 1015
         */
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int n = 1;
        for(int i = 1; i <= k + 1; i++){
            if(n % k == 0){
                return i;
            }
            n = (n * 10 + 1) % k;
        }
        return Integer.MAX_VALUE;
    }
}