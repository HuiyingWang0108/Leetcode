import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        obj.findDisappearedNumbers(nums);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 1010/997
         * nums: [4, 3, 2, 7, 8, 2, 3, 1]
         * index:[0, 1, 2, 3, 4, 5, 6, 7]
         *       [1, 2, 3, 4, 5, 6, 7, 8]
         * step1, for i = [0, n) do
         * 
         */
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        int[] occurs = new int[n];
        for (int i = 0; i < n; i++) {
            occurs[nums[i] - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (occurs[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}