import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// import java.util.stream.*;
import java.util.Collections;

public class FourSum2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        List<List<Integer>> rList = new ArrayList<List<Integer>>();

        //sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> key = new ArrayList<Integer>();
                int val = 0;
                key.add(i);
                key.add(j);
                val = nums[i] + nums[j];
                map.put(key, val);
            }
        }

        List<List<Integer>> fouSumList = new ArrayList<List<Integer>>();

        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

            int anotherVal = target - (Integer) entry.getValue();

            for (List<Integer> key : getKeys(map, anotherVal, entry.getKey())) {

                List<Integer> list = new ArrayList<Integer>();
                list.add(entry.getKey().get(0));
                list.add(entry.getKey().get(1));
                list.add(key.get(0));
                list.add(key.get(1));
                Collections.sort(list);// sort list
                if (!fouSumList.contains(list)) {
                    fouSumList.add(list);
                    // System.out.println("+++-------++sorted index list :"+ fouSumList);
                }
            }

        }

        for (List<Integer> l : fouSumList) {
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                subList.add(nums[l.get(i)]);
            }
            Collections.sort(subList);
            if (!rList.contains(subList)) {
                rList.add(subList);
            }

        }

        return rList;

    }

    private static Set<List<Integer>> getKeys(Map<List<Integer>, Integer> map, Integer value, List<Integer> oldKey) {

        Set<List<Integer>> result = new HashSet<>();
        if (map.containsValue(value)) {
            for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
                if (Objects.equals(entry.getValue(), value)) {// 去重
                    if (!oldKey.contains(entry.getKey().get(0)) && !oldKey.contains(entry.getKey().get(1))) {
                        result.add(entry.getKey());
                    }
                }
                // we can't compare like this, null will throws exception
                /*
                 * (if (entry.getValue().equals(value)) { result.add(entry.getKey()); }
                 */
            }
        }
        return result;

    }

    public static void main(String[] args) {
        FourSum3 fourSumOjt = new FourSum3();
        // int[] nums = {2,2,2,2,2,2};
        // int target = 8;
        // int[] nums =
        // {-490,-481,-471,-467,-453,-450,-446,-440,-437,-424,-423,-391,-384,-373,-358,-332,-318,-314,-311,-309,-299,-279,-270,-257,-243,-208,-205,-171,-153,-147,-142,-138,-129,-99,-20,-19,17,30,44,82,86,93,122,125,138,139,158,169,175,181,199,200,203,203,205,225,248,272,277,306,334,335,337,338,342,344,359,396,403,405,412,434,437,439,440,441,443,446,446,457,465,468,473,496};
        // int target = 1896;
        // int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        // int target = 0;
        // int[] nums = {-2,-1,-1,1,1,2,2};
        // int target = 0;
        int[] nums = { -5, 5, 4, -3, 0, 0, 4, -2 };
        int target = 4;
        // int target = 0;
        // int[] nums = {-1,1,0,0,-2,2};
        List<List<Integer>> l = fourSumOjt.fourSum(nums, target);
        System.out.println("+++++fourSumList :" + l);

    }
}
