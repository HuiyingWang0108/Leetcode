import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] digits = { 9, 9 , 9};
        obj.plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] arr;
        int p = 0;
        for (int i = n - 1; i >= 0; i--) {
            int m;
            if(i == n - 1){
                m = digits[i] + 1 + p;
            }else{
                m = digits[i] + p;
            }
            if (m < 10) {
                digits[i] = m;
                p = 0;
            } else {
                digits[i] = 0;
                p = 1;
            }
        }
        if (p == 0) {
            return digits;
        } else {
            // arr = new int[n + 1];
            // arr[0] = p;
            // // 插入第一个
            // for (int i = 0; i < n; i++) {
            //     arr[i + 1] = digits[i];
            // }
            arr = Arrays.copyOf(digits, n + 1);
            arr[0] = 1;
            
        }
        return arr;

    }
}