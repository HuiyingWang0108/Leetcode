public class IsPowerOfTwo{
    public static void main(String[] args) {
        
    }
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n <= 0 || n % 2 == 1)
           return false;
        n = n / 2;
        return isPowerOfTwo(n);
        
    }
}