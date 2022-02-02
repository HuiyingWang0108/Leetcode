import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        CanPartition obj = new CanPartition();
        // int[] nums = { 3, 3, 3, 4, 5 };
        int[] nums = { 2, 2, 1, 1 };
        obj.canPartition(nums);

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;

        Arrays.sort(nums);
        if (nums[n - 1] > sum) {
            return false;
        } else if (nums[n - 1] == sum) {
            return true;
        }
        /**
         * 数组nums[n]中，存在i(1 =< i <n )个数之和为sum
         */
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // boolean res = findSum(list, sum, 0);

        return findSum(nums, sum, 0);

    }

    public static boolean findSum(int[] nums, int sum, int index) {
        if(sum == 0){
            return true;
        }
        if(sum == 0) return true;
        if(nums.length ==index) return false;
        
        //exclusive
        boolean exclusive = findSum(nums,sum,index+1);
        //inclusive  
        boolean inclusive = false;
        if(sum-nums[index]>=0)
           inclusive = findSum(nums,sum-nums[index],index+1);
        
        return exclusive || inclusive;
        // boolean res = false;
        // for (int i = 0; i < list.size() - 1; i++) {
        //     if (sum == 0) {
        //         return true;
        //     } else if (sum < 0) {
        //         sum += list.get(i);
        //         res = findSum(list, sum);
        //     } else {
        //         sum -= list.get(i);
        //         list.remove(i);
        //         System.out.println(list.toString());
        //         res = findSum(list, sum);
        //     }
    }

}