public class MinimalTotalContainerSizeII {
    public static void main(String[] args) {
        /**
         * You want to move N items in k days (N >= k). You have to move at least one
         * item per day.
         * The items are listed in array P, where P[i] is size of item i.
         * You can move item i only if all items from 0 to [i - 1] are already moved.
         * Every day you need a container to pack the item and move it.
         * The container size needed for day i is the maximum item size moved on that
         * day.
         * Given k days and army P as the item sizes, find out the minimum total
         * container size required to move all the items.
         * 
         * input P = [10, 2, 20, 5, 15, 10, 1]
         * d = 3
         * output 31
         * day 1 - [10, 2, 20, 5, 15]. ContainerSize = 20
         * day 2 - [10]. ContainerSize = 10
         * day 3 - [1]. ContainerSize = 1
         * Total = 20 + 10 + 1 = 31
         * 
         * input P = [10, 2, 20, 5, 15, 10, 1] d = 5
         * output 43
         * day 1 - move [10]. ContainerSize = 10
         * day 2 - move [2]. ContainerSize = 2
         * day 3 - move [20, 5, 15]. ContainerSize = 20
         * day 4 - move [10]. ContainerSize = 10
         * day 5 - move [1]. ContainerSize = 1
         * Total= 10 + 2 + 20 + 10 + 1 = 43
         */
        int[] arr = {10, 2, 20, 5, 15, 10, 1};
        int d = 3;
        // int[] arr = {10, 2, 20, 5, 15, 10, 1};
        // int d = 5;
        int ans = minimalTotalContainerSize(arr, d);
        System.out.println(ans);

    }

    public static int minimalTotalContainerSize(int[] arr, int d) {
        int totalItems = arr.length;
        if (totalItems < d) {
            return -1;
        }
        int[][] dp = new int[totalItems][d + 1];//row direction is the items, col is the day
        int[] biggestItemSize = new int[totalItems];

        //initialization
        for (int i = 0; i < totalItems; i++) {
            for (int j = 0; j <= d; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int maxItemSize = Integer.MIN_VALUE;//any numbers less than 0
        for (int i = totalItems - 1; i >= 0; i--) {
            if (maxItemSize < arr[i]) {
                maxItemSize = arr[i];
            }
            dp[i][d] = maxItemSize;
            biggestItemSize[i] = maxItemSize;
        }

        for (int i = totalItems - 2; i >= 0; i--) {
            for (int j = d -1; j >= 1; j--) {
                int biggest = 0;
                int best = Integer.MAX_VALUE;
                for(int k = i; k < totalItems-(d-j); k++){
                    biggest = Integer.max(biggest, arr[k]);
                    
                    // Recurrence relation
                    best = Integer.min(best, biggest + dp[k+1][j+1]);
                }
                dp[i][j] = best;
            }
        }
        return dp[0][1];
    }   
}