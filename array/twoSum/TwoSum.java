public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        /**
         * time O(n), space O(1)
         * two pointers
         */
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }
}