public class IsHappy {
    // leetcode 202
    public static void main(String[] args) {
        IsHappy obj = new IsHappy();
        int n = 2;
        obj.isHappy(n);
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int m = 0;
        while (n > 0) {
            m += Math.pow(n % 10, 2);
            n = n / 10;
        }
        // stack overflow without this 
        if (m % 5 == 0 && m % 10 != 0) {
            return false;
        }
        
        return isHappy(m);
    }
}