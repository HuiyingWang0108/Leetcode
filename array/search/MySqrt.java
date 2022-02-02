public class MySqrt {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        long low = 0, high = x;
        int res = 0;
        while(low <= high){
            long mid = (low + high) / 2;
            if(mid * mid <= x){
                res = (int)mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return res;
    }
}