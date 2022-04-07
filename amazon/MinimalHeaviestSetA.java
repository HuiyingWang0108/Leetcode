import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimalHeaviestSetA{
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        // arr.add(3);
        // arr.add(7);
        // arr.add(5);
        // arr.add(6);
        // arr.add(2);
        arr.add(10);
        // arr.add(10);
        // arr.add(10);
        minimalHeaviestSetA(arr);
        
    }
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        List<Integer> minimalHeaviestSetA = new ArrayList<>();
        Collections.sort(arr, Collections.reverseOrder());
        int sum = 0;
        int minimalSum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        for(int i = 0; i < arr.size(); i++){
            if(minimalSum > (sum / 2)) {
                break;
            }
            minimalSum += arr.get(i);
            res.add(arr.get(i));
        }
        for(int i = res.size() - 1; i >= 0; i--) {
            minimalHeaviestSetA.add(res.get(i));
        }
        return minimalHeaviestSetA;
    }


}