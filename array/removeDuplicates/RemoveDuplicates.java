public class RemoveDuplicates{
    public static void main(String[] args){
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] nums = {1, 1, 1, 2};
        obj.removeDuplicates(nums);
    }
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return n;
        }
        int currentIndex = 0;
        //-> 112
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[currentIndex]){
                currentIndex ++;
                nums[currentIndex] = nums[i];
            }
        }
        return currentIndex + 1;
    }
}