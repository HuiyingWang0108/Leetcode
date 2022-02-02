import java.util.ArrayList;
import java.util.List;

public class AtMostNGivenDigitSet {
    List<Integer> nList = new ArrayList<Integer>();
    int l;

    public static void main(String[] args) {
        AtMostNGivenDigitSet obj = new AtMostNGivenDigitSet();
        String[] digits = { "3", "4", "5", "6" };
        int n = 64;
        obj.atMostNGivenDigitSet(digits, n);

    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        /**
         * 1 <= digits.length <= 9
         * digits[i].length == 1
         * digits[i] is a digit from '1' to '9'.
         * All the values in digits are unique.
         * digits is sorted in non-decreasing order.
         * 1 <= n <= 109
         */
        while (n != 0) {
            nList.add(n % 10);
            n = n / 10;
        }
        l = digits.length;
        int sum = 0;
        for (int i = 1; i < nList.size(); i++) {
            sum += Math.pow(l, i);
        }
        // i = nList.size()
        int nListSum =  digitsEqualNlist(digits, nList.size() - 1) ;

        return sum + nListSum;
    }

    private int digitsEqualNlist(String[] digits, int i) {
        int count = countDigitsLessNList(digits, nList.get(i));
        int sum = count * (int)Math.pow(l, i);
        int sum_next = 0;
        int res = 0;
        if(i == 0){
            for(int k = 0; k < l; k++){
                if(Integer.parseInt(digits[k]) <= nList.get(0)){
                    res++;
                }
            }
            return res;
        }
        if (existOfDigits(digits, nList.get(i))) {
            sum_next = digitsEqualNlist(digits, i - 1);
        }
        return sum + sum_next;
    }

    private boolean existOfDigits(String[] digits, Integer integer) {
        for (int i = 0; i < digits.length; i++) {
            if (integer == Integer.parseInt(digits[i])) {
                return true;
            }
        }
        return false;
    }

    private int countDigitsLessNList(String[] digits, Integer integer) {
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (Integer.parseInt(digits[i]) < integer) {
                count++;
                continue;
            }
        }
        return count;
    }

    // l的i次方
    // private int fun(int l, int i) {
    //     if (i == 0) {
    //         return 1;
    //     }
    //     int res = 1;
    //     while (i != 0) {
    //         res *= l;
    //         i--;
    //     }
    //     return res;
    // }
}
