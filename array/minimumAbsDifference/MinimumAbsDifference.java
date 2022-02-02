import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            min = Integer.min(min, arr[i] - arr[i - 1]);
        }
        for(int i = 1; i < n; i++){
            List<Integer> list = new ArrayList<Integer>();
            if(min == arr[i] - arr[i - 1]){
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}