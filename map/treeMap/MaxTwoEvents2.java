import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MaxTwoEvents2 {
    public static void main(String[] args) {
        MaxTwoEvents2 obj = new MaxTwoEvents2();
        // int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        // int[][] events = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        // int[][] events = {{35, 90, 47}, {72, 80, 70}};
        int[][] events = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}, {1, 4, 10}};
        // int[][] events = { { 66, 97, 90 }, { 98, 98, 68 }, { 38, 49, 63 }, { 91, 100, 42 }, { 92, 100, 22 },
        //         { 1, 77, 50 }, { 64, 72, 97 } };
        obj.maxTwoEvents(events);

    }

    public int maxTwoEvents(int[][] events) {
        /**
         * same to MergeIntervals.java
         * 1
         */
        // 1, sorted events by ending time
        Arrays.sort(events, (int[] e1, int[] e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        for (int[] event : events) {
            System.out.println("----event------" + Arrays.toString(event));
        }
        // 2, save treeMap: key is ending time, value is the max value
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        int max = 0, res = 0;
        for(int[] event: events){
            max = Integer.max(max, event[2]);
            if(!treeMap.containsValue(max)){
                treeMap.put(event[1], max);
            }
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println("------entry---------" + entry.getKey() + "---v--" + entry.getValue());
        }
        // 3, loop events: event[0] >= key + 1 as a given key, return
        for (int[] event : events) {
            Map.Entry<Integer, Integer> map = treeMap.floorEntry(event[0] - 1);
            int val = 0;
            if (map != null) {
                val = map.getValue();
            }
            res = Integer.max(res, val + event[2]);
            System.out.println("---res--------" + res);
        }
        return res;
    }
}