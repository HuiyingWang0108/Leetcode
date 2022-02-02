import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] nums = {3,2,3};
        obj.majorityElement(nums);


    }

    public int majorityElement(int[] nums) {
        /**
         * time O(n)
         * space O(n)
         */
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int n = nums.length;
        // for(int i = 0; i < n; i++){
        //     map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        // }
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //     if(entry.getValue() > (n >> 1)){
        //         return entry.getKey();
        //     }
        // }
        // return -1;
         /**
         * time O(n)
         * space O(1)
         */
        int n = nums.length;
        int res = nums[0];
        int occurs = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == res){
                occurs++;
            }else{
                occurs--;
                if(occurs == 0){
                    res = nums[i];
                    occurs = 1;
                }
            }
        }
        return res;

    }
}