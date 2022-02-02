import java.util.List;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.stream.*;
import java.util.Collections;



public class FourSum{
    public static void main(String[] args) {
        FourSum fourSumOjt = new  FourSum();
        // int[] nums = {2,2,2,2,2,2};
        // int target = 8;
        // int[] nums = {-2,-1,-1,1,1,2,2};
        // int target = 0;
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        int target = 4;
        // int target = 0;
        // int[] nums = {-1,1,0,0,-2,2};
        List<List<Integer>> fourSumList = fourSumOjt.fourSum(nums, target);
        System.out.println(fourSumList);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int sum = 0;
        List<List<Integer>> fouSumList = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    int l = target - sum;
                    for(int m = k + 1; m < nums.length; m++){
                        if(l == nums[m]){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            Collections.sort(list);//sort list
                            fouSumList.add(list);
                        }
                    }
                }
                
            }
        }
        List<List<Integer>>  newList = new ArrayList<List<Integer>>();
        for(List<Integer> l: fouSumList){
            if(!newList.contains(l)){//去重
                newList.add(l);
            }
        }
        return newList;
        
    }

}