public class MyPow{
    public static void main(String[] args) {
        MyPow obj = new MyPow();
        double x = 2.0;
        int n = -200;
        obj.myPow(x, n);
        
    }
    public double myPow(double x, int n) {
        // if(x - 1 == 0){
        //     return x;
        // }
        // double res;
        // if(n == 0){
        //     return 1;
        // }else if(n > 0){
        //     res = x;
        //     for(int i = 1; i < n; i++){
        //     res *= x;
        //     }
        // }else{
        //     res = 1;
        //     for(int i = 0; i < -n; i++){
        //         res /= x;
        //     }
        // }
        return Math.pow(x, n);
    }
}