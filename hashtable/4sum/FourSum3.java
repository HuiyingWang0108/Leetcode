import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class FourSum3{
    public static void main(String[] args) {
        FourSum3 fourSumOjt = new  FourSum3();
        int[] nums = {-3,-4,-5,0,-5,-2,5,2,-3};
        int target = 3;
        // int[] nums = {2,2,2,2,2,2};
        // int target = 8;
        // int[] nums = {-490,-481,-471,-467,-453,-450,-446,-440,-437,-424,-423,-391,-384,-373,-358,-332,-318,-314,-311,-309,-299,-279,-270,-257,-243,-208,-205,-171,-153,-147,-142,-138,-129,-99,-20,-19,17,30,44,82,86,93,122,125,138,139,158,169,175,181,199,200,203,203,205,225,248,272,277,306,334,335,337,338,342,344,359,396,403,405,412,434,437,439,440,441,443,446,446,457,465,468,473,496};
        // int target = 1896;
        // int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        // int target = 0;
        // int[] nums = {-2,-1,-1,1,1,2,2};
        // int target = 0;
        // int[] nums = {-5,5,4,-3,0,0,4,-2};
        // int target = 4;
        // int target = 0;
        // int[] nums = {-1,1,0,0,-2,2};
        List<List<Integer>> l = fourSumOjt.fourSum(nums, target);
        System.out.println("+++++fourSumList :"+ l);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>>  rList = new ArrayList<List<Integer>>();
        //special case 1
        if(nums.length < 4){
            return rList;
        }
        //special case 2
        if(nums.length == 4){
            if(target == nums[0] + nums[1] + nums[2] + nums[3]){
                List<Integer> temp=new ArrayList<>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                temp.add(nums[3]);
                rList.add(temp);
                return rList;
            }
        }
        //sort nums
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int start = j + 1, end = nums.length -1;
                while(start < end){
                    int sum = nums[start]+nums[end]+nums[j]+nums[i];
                    if(sum == target){
                        if(start + 1 < end && nums[start] == nums[start + 1]){//去重
                            start++;
                            continue;
                        }
                        if(start + 1 < end && nums[end - 1] == nums[end]){//去重
                            end--;
                            continue;
                        }
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        if(!rList.contains(temp))
                        rList.add(temp);
                        start++;
                        end--;
                    }else if(sum > target){
                        if(nums[end - 1] == nums[end]){//去重
                            end--;
                            continue;
                        }
                        end--;
                    }else{
                        if(nums[start] == nums[start + 1]){//去重
                            start++;
                            continue;
                        }
                        start++;
                    }
                } 
            }
        }

        return rList;
    }

}