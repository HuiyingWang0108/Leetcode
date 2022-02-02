import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class ThreeSum{
    public static void main(String[] args) {
        ThreeSum threeSum = new  ThreeSum();
        // int[] nums = {2,2,2,2,2,2};
        // int[] nums = {-490,-481,-471,-467,-453,-450,-446,-440,-437,-424,-423,-391,-384,-373,-358,-332,-318,-314,-311,-309,-299,-279,-270,-257,-243,-208,-205,-171,-153,-147,-142,-138,-129,-99,-20,-19,17,30,44,82,86,93,122,125,138,139,158,169,175,181,199,200,203,203,205,225,248,272,277,306,334,335,337,338,342,344,359,396,403,405,412,434,437,439,440,441,443,446,446,457,465,468,473,496};
        // int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        // int[] nums = {-2,-1,-1,1,1,2,2};
        // int target = 0;
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        List<List<Integer>> l = threeSum.threeSum(nums);
        System.out.println("+++++threeSum--- :"+ l);

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  rList = new ArrayList<List<Integer>>();

        //sort nums
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        if(nums.length < 3){
            return rList;
        }

        //save first three indexes as a map
        for(int i = 0; i < nums.length - 2; i++){

            int start = i + 1, end = nums.length -1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    if(!rList.contains(temp)){
                        rList.add(temp);
                        while(start < end && nums[start]==nums[start+1]) start++;
                        while(start < end && nums[end]==nums[end-1]) end--;
                        start++;
                        end--;
                    }
                }else if(sum > 0){
                    end--;
                }else{
                    start++;
                }
            } 
        }

        return rList;
    }

}