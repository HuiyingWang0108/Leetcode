public class RemoveElement{
    public static void main(String[] args){
        RemoveElement obj = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        obj.removeElement(nums, val);
    }
    public int removeElement(int[] nums, int val) {
        int k = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                nums[k] = nums [i];
                k++;
            }
        }
        return k;
        
    }
}