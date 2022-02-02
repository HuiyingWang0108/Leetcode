import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MaxTwoEvents {
    public static void main(String[] args) {
        MaxTwoEvents obj = new MaxTwoEvents();
        // int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        // int[][] events = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        // int[][] events = {{35, 90, 47}, {72, 80, 70}};
        int[][] events = { { 66, 97, 90 }, { 98, 98, 68 }, { 38, 49, 63 }, { 91, 100, 42 }, { 92, 100, 22 },
                { 1, 77, 50 }, { 64, 72, 97 } };
        // int[][] events = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}, {1, 4, 10}};
        // int[][] events = {{10, 83, 53}, {63, 87, 45}, {97, 100, 32}, {51, 61, 16}};
        // [[66,97,90],[98,98,68],[38,49,63],[91,100,42],[92,100,22],[1,77,50],[64,72,97]]
        // int[][] events = { { 66, 97, 90 }, { 98, 98, 68 }, { 38, 49, 63 }, { 91, 100,
        // 42 }, { 92, 100, 22 },
        // { 1, 77, 50 }, { 64, 72, 97 } };
        // [[66,97,90],[98,98,68],[38,49,63],[91,100,42],[92,100,22],[1,77,50],[64,72,97]]
        // int[][] events = { { 66, 97, 90 }, { 98, 98, 68 }, { 38, 49, 63 }, { 91, 100,
        // 42 }, { 92, 100, 22 },
        // { 1, 77, 50 }, { 64, 72, 97 } };
        obj.maxTwoEvents(events);

    }

    public int maxTwoEvents(int[][] events) {

        //1, sorted events by starting time
        Arrays.sort(events, (int[] e1, int[] e2) ->{
            return Integer.compare(e1[0],e2[0]);
            });
        for(int[] event: events){
            System.out.println("----event------" + Arrays.toString(event));
        }

        //2, save treeMap: key is starting time, value is the max value 倒序！！！
        TreeMap<Integer, Integer> navMap = new TreeMap<Integer, Integer>();
        int max = 0;
        for (int i=events.length-1; i>=0; i--) {
            max = Integer.max(max, events[i][2]);
            navMap.put(events[i][0], max);//妙处！
        }
        // for(int[] event: events){
        //     max = Integer.max(max, event[2]);
        //     navMap.put(event[0], max);
        // }
        for (Map.Entry<Integer, Integer> entry : navMap.entrySet()) {
            System.out.println("------entry---------" + entry.getKey() + "---v--" + entry.getValue());
        }
        int res = 0;
        for (int[] event : events) {
            res = Integer.max(res, event[2] +
            Optional.ofNullable(navMap.ceilingEntry(event[1] +1))
            .map(e->e.getValue() ).orElse(0) );
            System.out.println("--------res----" + res);
        }
        return res;
        /**
         * save a treeMap by starting time. O(nlogn)
         * loop events save by ending time
         */
        // TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        // int res = 0;
        // int max = 0;
        // //O(nlogn)
        // for (int[] event : events) {
        //     treeMap.put(event[0], Integer.max(max, event[2]));
        // }
        // // for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
        // //     System.out.println("------entry---------" + entry.getKey() + "---v--" + entry.getValue());
        // // }
        // //O(n*n)
        // for (int[] event : events) {
        //     //get key > event[1] subMap
        //     SortedMap<Integer,Integer> subMap = treeMap.tailMap(event[1], false);
        //     int max_sub = 0;
        //     for(Map.Entry<Integer,Integer> entry: subMap.entrySet()){
        //         max_sub = Integer.max(max_sub, entry.getValue());
        //     }
        //     res = Integer.max(res, event[2] + max_sub);
        //     System.out.println("--------res----" + res);
        // }
        // return res;

       
        /** way 2 */
        // int max = 0;
        // TreeMap<int[], Integer> treeMap = new TreeMap<>(Arrays::compare);
        // for (int i = 0; i < events.length; i++) {
        // int[] k = { events[i][0], events[i][1] };
        // int v = events[i][2];
        // if (treeMap.containsKey(k)) {
        // int kv = treeMap.get(k);
        // if (v > kv) {
        // treeMap.put(k, v);
        // }

        // } else {
        // treeMap.put(k, v);
        // }
        // }

        // for (Map.Entry<int[], Integer> entry : treeMap.entrySet()) {
        // System.out.println("------entry---------" + Arrays.toString(entry.getKey()) +
        // "---v--" + entry.getValue());
        // }

        // Vector<int[]> vector = new Vector<int[]>(treeMap.keySet());
        // for(int i = 0; i < vector.size() - 1; i++){
        // for(int j = vector.size() - 1; j >= i + 1 ; j--){
        // if(vector.get(i)[1] < vector.get(j)[0]){
        // int max1 = treeMap.get(vector.get(i)) + treeMap.get(vector.get(j));
        // if (max < max1) {
        // max = max1;
        // System.out.println("----------max 2------" + max);
        // }
        // }
        // }
        // }

        // for (int[] k : treeMap.keySet()) {
        // if (max < treeMap.get(k)) {
        // max = treeMap.get(k);
        // // System.out.println("----------max1------" + max);
        // }
        // Integer.max(max, treeMap.get(k));
        // }
        // return max;
        
    }
}