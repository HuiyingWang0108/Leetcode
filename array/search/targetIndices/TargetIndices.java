import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {
    public static void main(String[] args) {

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        //<i> 求非降序范围[left, right)内第一个不小于value的值的位置,诀窍是搜索区间[left, right)左闭右开！
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else
                r = mid;
        }
        while (l < nums.length && nums[l] == target) {
            res.add(l);
            l++;
        }
        return res;
    }
}