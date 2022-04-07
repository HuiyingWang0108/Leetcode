public class MinimalTotalContainerSize {
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
        int totalContainers = arr.length;
        if (d > totalContainers) {
            return -1;
        }
        
        //define dp[]
        int[] dp = new int[totalContainers];
        
        //initialization dp[]
        // int maxDiff = Integer.MIN_VALUE;
        int maxDiff = 0;
        int maxContainersOneDay = totalContainers - d + 1;
        for (int k = totalContainers - 1; k > totalContainers - 1 - maxContainersOneDay; k--) {
            maxDiff = Math.max(maxDiff, arr[k]);
            dp[k] = maxDiff;
        }
        for (int day = d - 1; day > 0; day--) {
            int maxEndIndex = (totalContainers - 1) - (d -day);
            int maxStartIndex = maxEndIndex - maxContainersOneDay + 1;
            for (int startIndex = maxStartIndex; startIndex <= maxEndIndex; startIndex++) {
                dp[startIndex] = Integer.MAX_VALUE;
                int maxDiffOfTheDay = Integer.MIN_VALUE;
                for(int endIndex = startIndex; endIndex <= maxEndIndex; endIndex++){
                    maxDiffOfTheDay = Math.max(maxDiffOfTheDay, arr[endIndex]);

                    int totalDiff = maxDiffOfTheDay + dp[endIndex+1];

                    dp[startIndex] = Math.min(dp[startIndex], totalDiff);
                }
            }
        }
        return dp[0];
    }   
}