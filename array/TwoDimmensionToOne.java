import java.lang.reflect.Array;

public class TwoDimmensionToOne{
    public static void main(String[] args){}
    /**
     * Compiler Blocker: Memory Aliasing
     * @param nums
     * @retuzzrn
     */
    // public static int[] twoDimmensionToOne(int[][] nums){
    //     int[] arry = {};
    //     for(int i = 0; i < nums.length; i++){
    //         arry[i] = 0;
    //         for(int j = 0; j < nums[i].length; j++){
    //             arry[i] += nums[i][j];
    //         }
    //     }
    //     return arry;
    // }
   
    public static int[] twoDimmensionToOne(int[][] nums){
        int[] arry = {};
        for(int i = 0; i < nums.length; i++){
            int val = 0;
            for(int j = 0; j < nums[i].length; j++){
                val += nums[i][j];
            }
            arry[i] = val;
        }
        return arry;
    }
}