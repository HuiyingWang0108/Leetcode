import java.util.ArrayList;
import java.util.List;

public class MinimumSize {
    public static void main(String[] args) {
        MinimumSize obj = new MinimumSize();
        // int[] nums = { 10 };
        int[] nums = { 7, 17 };
        // int[] nums = {2,4,8,2};
        int maxOperations = 2;
        int res = obj.minimumSize(nums, maxOperations);
        System.out.println(res);

    }

    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        // List<Integer> list = Arrays.stream(nums).boxed().toList();
        // List list = Arrays.asList(nums);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        int max = findMax(list);
        if (n < maxOperations) {
            return max % (maxOperations + 1) == 0 ? max / (maxOperations + 1) : max / (maxOperations + 1) + 1;
        }
        for (int i = 0; i < maxOperations; i++) {
            int m1 = max / 2;
            int m2 = max - m1;
            list.add(m1);
            list.add(m2);
            int r = list.indexOf(max);
            list.remove(r);
            max = findMax(list);

        }
        max = findMax(list);
        return max;

    }

    public int findMax(List<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }

        return max;
    }
}