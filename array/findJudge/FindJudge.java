import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindJudge {
    public static void main(String[] args) {
        FindJudge obj = new FindJudge();
        int n = 2;
        int[][] trust = { { 1, 2 } };
        // int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        obj.findJudge(n, trust);
    }

    public int findJudge(int n, int[][] trust) {
        /**
         * findDiappearedNumbers/1010/997
         *  if a person is believing someone else than himself than that person is not qualified for being a judge 
         * or if a person is trusted by others and has everyone's favour i.e total of N-1 favours, than this person is truly the judge.
         */
        int[] occurs = new int[n];
        for(int i = 0; i < trust.length; i++){
            occurs[trust[i][1] - 1] += 1; 
        }
        int res = -1;
        for(int i = 0; i < n; i++){
            if(occurs[i] == n - 1){
                res = i + 1;
            }
        }
      
        for(int i = 0; i < trust.length; i++){
            if(res == trust[i][0])
                return -1;
        }
        return res;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Set<Integer> set = new HashSet<Integer>();
        // for (int i = 0; i < trust.length; i++) {
        //     set.add(trust[i][0]);
        //     map.put(trust[i][1], map.containsKey(trust[i][1]) ? map.get(trust[i][1]) + 1 : 1);
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() == n - 1 && !set.contains(entry.getKey())) {
        //         return entry.getKey();
        //     }
        // }
        // return -1;
    }
}