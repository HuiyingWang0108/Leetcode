import java.util.ArrayList;
import java.util.Arrays;

public class SubarraySum{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int s = 12, n = 5;
        ArrayList<Integer> res = subarraySum(arr, n, s);
        System.out.println(res);
        
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int p1 = 0, p2 = 0, sum = arr[0];
        while(p1 < n && p2 < n){
            if(sum < s) {
                p1++;
                if(p1 == n) {
                    break;
                }
                sum += arr[p1];
            }
            if (sum > s) {
                sum -= arr[p2];
                p2++;
            }
            if (sum == s) {
                res.add(p2 + 1);
                res.add(p1 + 1);
                return res;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(-1));

    }
}