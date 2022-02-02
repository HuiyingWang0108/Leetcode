public class SearchRange {
    public static void main(String[] args) {
        SearchRange obj = new SearchRange();
        int target = 1;
        int[] nums = { 1 };
        obj.searchRange(nums, target);

    }

    public int[] searchRange(int[] nums, int target) {
        /**
         * two times binary search
         * <i> 求非降序范围[left, right)内第一个不小于value的值的位置,诀窍是搜索区间[left, right)左闭右开！
         * 求下界，即找满足x >= target > target 条件的最小x的位置
         * step0, let left = 0, right = nums.length - 1
         * step1, while (left < right) do //搜索区间[first, last)不为空
         *              let mid = left + (right - left)/2 //防溢出
         *              if (nums[mid] < target)
         *                then left = mid + 1
         *              else then right = mid
         *        end
         * step2, return left //last也行，因为[first, last)为空的时候它们重合
         * 
         * <ii> 求非降序范围【left, right)内最后一个不大于value的值的位置,诀窍是搜索区间(left, right]左开右闭！
         * 求上界，找满足x < target 或 x <= target 条件的最大x的位置
         * step0, let left = 0, right = nums.length - 1
         * step1, while (left < right) do //搜索区间(first, last]不为空
         *              let mid = right - (right - left)/2 //防溢出
         *              if (nums[mid] > target)
         *                 then right = mid - 1
         *              else then left = mid
         *         end
         * step2, return left //last也行，因为[first, last)为空的时候它们重合
         */
        int[] res = { -1, -1 };
        if (nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        // 求下界，即找满足x >= target > target 条件的最小x的位置，
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid;
        }
        if (nums[left] == target) {
            res[0] = left;
        } else
            return res;

        // 求上界， 找满足x < target 或 x <= target 条件的最大x的位置
        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else
                left = mid;
        }
        if (nums[left] == target) {
            res[1] = left;
        } else
            return res;

        return res;
        /**
         * time: O(logn)
         * leetcode34. Find First and Last Position of Element in Sorted Array
         */
        // int left = 0;
        // int right = nums.length-1;
        // int result[] = {-1,-1};
        // while(left <= right) {
        // int mid = (right+left)/2;
        // if(nums[mid] == target) {
        // result[0] = mid;
        // right = mid-1;
        // } else if(nums[mid] < target) {
        // left = mid+1;
        // } else {
        // right = mid-1;
        // }
        // }

        // left = 0;
        // right = nums.length-1;
        // while(left <= right) {
        // int mid = (right + left) / 2;
        // if(nums[mid] == target) {
        // result[1] = mid;
        // left = mid+1;
        // } else if(nums[mid] < target) {
        // left = mid+1;
        // } else {
        // right = mid-1;
        // }
        // }

        // return result;

        /**
         * 最坏情况O(n)
         * binary search
         * step1, let array res = {-1, -1}
         * step2, if (array is null) then
         * return res
         * step3, using binary search, if (nums[mid] > target) then right = mid - 1, if
         * (nums[mid] < target) then left = mid + 1,
         * if (nums[mid] == target) using two pointers way
         * 
         * step4, if target doesn't exist in the nums
         * 
         */
        // int[] res = { -1, -1 };
        // if (nums.length == 0) {
        // return res;
        // }
        // int n = nums.length;
        // int left = 0, right = n - 1;
        // while (left <= right) {
        // int mid = (left + right) / 2;
        // if (nums[mid] > target) {
        // right = mid - 1;
        // } else if (nums[mid] < target) {
        // left = mid + 1;
        // } else {// nums[mid] == target
        // int p1 = mid, p2 = mid;
        // while (p1 >= 0 && nums[p1] == target) {
        // res[0] = p1;
        // p1--;
        // }
        // while (p2 < n && nums[p2] == target) {
        // res[1] = p2;
        // p2++;
        // }
        // return res;
        // }
        // }
        // if (left == n || nums[left] != target) {
        // return res;
        // }
        // return res;
        /**
         * time: O(n)
         * space:O(1)
         * two pointers:
         * pseudocode
         * step1, let left = 0, right = nums.length - 1
         * step2, while (left <= right) do
         * 
         * 
         */
        // int[] res = new int[2];
        // if (nums.length == 0) {
        // res[0] = -1;
        // res[1] = -1;
        // return res;
        // }

        // int n = nums.length, left = 0, right = n - 1;
        // while (left <= right) {
        // if (nums[left] < target) {
        // left++;
        // }
        // if (nums[right] > target) {
        // right--;
        // }
        // if (left == n || right == -1 || nums[left] > target) {
        // res[0] = -1;
        // res[1] = -1;
        // break;
        // }
        // if (target == nums[left] && target == nums[right]) {
        // res[0] = left;
        // res[1] = right;
        // break;
        // }

        // }
        // return res;
    }
}